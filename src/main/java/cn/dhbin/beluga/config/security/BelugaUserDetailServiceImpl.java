package cn.dhbin.beluga.config.security;

import cn.dhbin.beluga.entity.SysPerm;
import cn.dhbin.beluga.entity.SysUser;
import cn.dhbin.beluga.entity.SysUserRole;
import cn.dhbin.beluga.service.SysPermService;
import cn.dhbin.beluga.service.SysRoleMenuService;
import cn.dhbin.beluga.service.SysUserRoleService;
import cn.dhbin.beluga.service.SysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/7/1
 */
@Component
@RequiredArgsConstructor
public class BelugaUserDetailServiceImpl implements UserDetailsService {

    private final SysUserService sysUserService;

    private final SysUserRoleService sysUserRoleService;

    private final SysRoleMenuService sysRoleMenuService;

    private final SysPermService sysPermService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = this.sysUserService.getByUsername(username);
        if (sysUser == null) {
            throw new UsernameNotFoundException(username + " 不存在");
        }
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
        return User.builder().accountExpired(false)
                .accountLocked(false)
                .authorities(mergePermList.toArray(new String[]{}))
                .username(sysUser.getUsername())
                .password(sysUser.getPassword())
                .build();
    }

}
