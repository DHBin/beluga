package cn.dhbin.beluga.upms.service.impl;

import cn.dhbin.beluga.upms.entity.SysRole;
import cn.dhbin.beluga.upms.entity.SysUser;
import cn.dhbin.beluga.upms.mapper.SysUserMapper;
import cn.dhbin.beluga.upms.model.dto.UserDto;
import cn.dhbin.beluga.upms.model.enums.ErrorCode;
import cn.dhbin.beluga.upms.service.SysRoleService;
import cn.dhbin.beluga.upms.service.SysUserRoleService;
import cn.dhbin.beluga.upms.service.SysUserService;
import cn.dhbin.beluga.util.AopUtil;
import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.core.restful.util.ApiAssert;
import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl extends MinionServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    private static final String CACHE_NAME = "sysUser";

    private final PasswordEncoder passwordEncoder;

    private final SysUserRoleService sysUserRoleService;

    private final SysRoleService sysRoleService;

    @Override
    @Cacheable(cacheNames = CACHE_NAME, key = "#username")
    public SysUser getByUsername(String username) {
        return lambdaQuery().eq(SysUser::getUsername, username).one();
    }

    @Override
    public void createUser(SysUser sysUser) {
        AopUtil.getCurrentProxy(SysUserService.class).createUser(sysUser, null);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createUser(SysUser sysUser, List<Long> roles) {
        Integer count = this.lambdaQuery().eq(SysUser::getUsername, sysUser.getUsername()).count();
        ApiAssert.isFalse(ErrorCode.USERNAME_EXITED, count > 0);
        sysUser.setPassword(passwordEncoder.encode(sysUser.getPassword()));
        save(sysUser);
        if (CollUtil.isNotEmpty(roles)) {
            this.sysUserRoleService.updateUserRole(roles, sysUser.getId());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUser(SysUser sysUser, List<Long> roles) {
        Integer count = this.lambdaQuery().eq(SysUser::getUsername, sysUser.getUsername())
                .ne(SysUser::getId, sysUser.getId()).count();
        ApiAssert.isFalse(ErrorCode.USERNAME_EXITED, count > 0);
        sysUser.setPassword(null);
        this.sysUserRoleService.updateUserRole(roles, sysUser.getId());
        AopUtil.getCurrentProxy(SysUserService.class).updateByIdAndReturn(sysUser);
    }

    @Override
    public IPage<UserDto> list(PageModel<SysUser> pageModel) {
        Page<SysUser> userPage = pageModel.convert();
        return this.page(userPage)
                .convert(sysUser -> {
                    UserDto dto = sysUser.convert(UserDto.class);
                    List<Long> roles = this.sysRoleService.getRoleByUserId(dto.getId()).stream()
                            .map(SysRole::getId)
                            .collect(Collectors.toList());
                    dto.setRoles(roles);
                    dto.setPassword("****");
                    return dto;
                });
    }

    @Override
    @CacheEvict(cacheNames = CACHE_NAME, key = "#username")
    public void changePassword(String username, String newPassword) {
        Assert.notNull(username, "username must not null.");
        Assert.notNull(newPassword, "newPassword must not null.");
        this.lambdaUpdate().set(SysUser::getPassword, passwordEncoder.encode(newPassword))
                .eq(SysUser::getUsername, username)
                .update();
    }

    @Override
    @CachePut(cacheNames = CACHE_NAME, key = "#entity.username")
    public SysUser updateByIdAndReturn(SysUser entity) {
        return super.updateByIdAndReturn(entity);
    }


    @Override
    @CacheEvict(cacheNames = CACHE_NAME, key = "#entity.username")
    public boolean updateById(SysUser entity) {
        return super.updateById(entity);
    }

    @Override
    @CachePut(cacheNames = CACHE_NAME, key = "#id")
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }

}

