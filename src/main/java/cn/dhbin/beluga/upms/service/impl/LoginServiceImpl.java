package cn.dhbin.beluga.upms.service.impl;

import cn.dhbin.beluga.upms.config.UpmsConstant;
import cn.dhbin.beluga.upms.entity.SysPerm;
import cn.dhbin.beluga.upms.entity.SysRole;
import cn.dhbin.beluga.upms.entity.SysUser;
import cn.dhbin.beluga.upms.entity.SysUserRole;
import cn.dhbin.beluga.upms.exception.LoginFailedException;
import cn.dhbin.beluga.upms.model.PermUser;
import cn.dhbin.beluga.upms.service.*;
import cn.dhbin.beluga.util.CacheUtil;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/7/1
 */
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final PasswordEncoder passwordEncoder;

    private final SysUserService sysUserService;

    private final SysUserRoleService sysUserRoleService;

    private final SysRoleMenuService sysRoleMenuService;

    private final SysPermService sysPermService;

    private final SysRoleService sysRoleService;

    private final RedisTemplate<String, Object> redisTemplate;


    @Override
    public String login(String username, String password) throws LoginFailedException {
        SysUser sysUser = sysUserService.getByUsername(username);
        if (sysUser == null) {
            throw new LoginFailedException(StrUtil.format("用户名[{}]不存在", username));
        }
        if (!passwordEncoder.matches(password, sysUser.getPassword())) {
            throw new LoginFailedException(StrUtil.format("用户名[{}]密码错误", username));
        }
        PermUser permUser = buildPermUser(sysUser);
        String token = UUID.fastUUID().toString(true);
        permUser.setToken(token);
        // 存进缓存
        redisTemplate.opsForValue().set(buildCacheKey(token), permUser, UpmsConstant.AUTH_PERIOD_OF_VALIDITY, TimeUnit.SECONDS);
        return token;
    }

    @Override
    @Nullable
    public PermUser getPermUser(String token) {
        PermUser permUser = (PermUser) redisTemplate.opsForValue().get(buildCacheKey(token));
        if (permUser == null) {
            return null;
        }
        return permUser.getUsername() == null ? null : permUser;
    }

    @Override
    public void logout(String token) {
        redisTemplate.delete(buildCacheKey(token));
    }

    private PermUser buildPermUser(@NonNull SysUser sysUser) {
        List<SysRole> roles = this.sysRoleService.getRoleByUserId(sysUser.getId());
        // 用户-角色关联关系
        List<SysUserRole> userRoleList = sysUserRoleService.getByUserId(sysUser.getId());

        // 角色-权限
        List<String> rolePermList = userRoleList
                .stream()
                .map(sysUserRole -> sysPermService.getByRoleId(sysUserRole.getRid()))
                .flatMap(Collection::stream)
                .map(SysPerm::getAuthorizations)
                .collect(Collectors.toList());

        // 角色-菜单-权限
        List<String> roleMenuPermList = userRoleList.stream()
                .map(sysUserRole -> sysRoleMenuService.getByRoleId(sysUserRole.getRid()))
                .flatMap(Collection::stream)
                .map(sysRoleMenu -> sysPermService.getByMenuId(sysRoleMenu.getMid()))
                .flatMap(Collection::stream)
                .map(SysPerm::getAuthorizations)
                .collect(Collectors.toList());

        List<String> mergePermList = new ArrayList<>();
        mergePermList.addAll(rolePermList);
        mergePermList.addAll(roleMenuPermList);
        PermUser permUser = new PermUser();
        permUser.setRoles(roles.stream().map(SysRole::getRoleKey).distinct().collect(Collectors.toList()));
        permUser.setUsername(sysUser.getUsername())
                .setId(sysUser.getId())
                .setAuthorities(mergePermList);
        return permUser;
    }

    private String buildCacheKey(String token) {
        return CacheUtil.buildCacheKey(UpmsConstant.AUTH_KEY_PREFIX, token);
    }
}
