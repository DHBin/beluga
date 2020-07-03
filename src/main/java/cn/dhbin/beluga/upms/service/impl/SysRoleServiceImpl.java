package cn.dhbin.beluga.upms.service.impl;

import cn.dhbin.beluga.upms.config.UpmsConstant;
import cn.dhbin.beluga.upms.entity.SysRole;
import cn.dhbin.beluga.upms.entity.SysRoleMenu;
import cn.dhbin.beluga.upms.entity.SysRolePerm;
import cn.dhbin.beluga.upms.entity.SysUserRole;
import cn.dhbin.beluga.upms.mapper.SysRoleMapper;
import cn.dhbin.beluga.upms.model.dto.SysRoleDto;
import cn.dhbin.beluga.upms.service.SysRoleMenuService;
import cn.dhbin.beluga.upms.service.SysRolePermService;
import cn.dhbin.beluga.upms.service.SysRoleService;
import cn.dhbin.beluga.upms.service.SysUserRoleService;
import cn.dhbin.beluga.util.AopUtil;
import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
@RequiredArgsConstructor
public class SysRoleServiceImpl extends MinionServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    private final SysUserRoleService sysUserRoleService;

    private final SysRolePermService sysRolePermService;

    private final SysRoleMenuService sysRoleMenuService;

    @Override
    public List<SysRole> getRoleByUserId(Long userId) {
        List<SysUserRole> sysUserRoles = sysUserRoleService.getByUserId(userId);
        return sysUserRoles.stream().map(sysUserRole -> AopUtil.getCurrentProxy(SysRoleService.class).getById(sysUserRole.getRid()))
                .collect(Collectors.toList());
    }

    @Override
    @Cacheable(cacheNames = UpmsConstant.CACHE_ROLE_PREFIX, key = "#id")
    public SysRole getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    @CachePut(cacheNames = UpmsConstant.CACHE_ROLE_PREFIX, key = "#entity.id")
    public SysRole updateByIdAndReturn(SysRole entity) {
        return super.updateByIdAndReturn(entity);
    }

    @Override
    @CacheEvict(cacheNames = UpmsConstant.CACHE_ROLE_PREFIX, key = "#entity.id")
    public boolean updateById(SysRole entity) {
        return super.updateById(entity);
    }

    @Override
    public IPage<SysRoleDto> list(PageModel<SysRole> pageModel) {
        Page<SysRole> page = pageModel.convert();
        return this.lambdaQuery().page(page)
                .convert(sysRole -> {
                    SysRoleDto dto = sysRole.convert(SysRoleDto.class);
                    List<String> perms = sysRolePermService.getByRoleId(dto.getId()).stream()
                            .map(SysRolePerm::getPid).collect(Collectors.toList());
                    dto.setPerms(perms);
                    return dto;
                });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(SysRole sysRole, List<String> perms) {
        this.save(sysRole);
        this.sysRolePermService.updateByRoleId(sysRole.getId(), perms);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(SysRole sysRole, List<String> perms) {
        AopUtil.getCurrentProxy(SysRoleService.class).updateByIdAndReturn(sysRole);
        this.sysRolePermService.updateByRoleId(sysRole.getId(), perms);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(Serializable id) {
        this.sysRolePermService.remove(new LambdaQueryWrapper<SysRolePerm>().eq(SysRolePerm::getRid, id));
        this.sysRoleMenuService.remove(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getRid, id));
        this.sysUserRoleService.remove(new LambdaQueryWrapper<SysUserRole>().eq(SysUserRole::getRid, id));
        return super.removeById(id);
    }

}
