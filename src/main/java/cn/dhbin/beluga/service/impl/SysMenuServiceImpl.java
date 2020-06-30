package cn.dhbin.beluga.service.impl;

import cn.dhbin.beluga.config.Constant;
import cn.dhbin.beluga.entity.SysMenu;
import cn.dhbin.beluga.entity.SysMenuPerm;
import cn.dhbin.beluga.entity.SysRoleMenu;
import cn.dhbin.beluga.entity.SysUserRole;
import cn.dhbin.beluga.mapper.SysMenuMapper;
import cn.dhbin.beluga.model.dto.SysMenuDto;
import cn.dhbin.beluga.model.enums.MenuType;
import cn.dhbin.beluga.service.SysMenuPermService;
import cn.dhbin.beluga.service.SysMenuService;
import cn.dhbin.beluga.service.SysRoleMenuService;
import cn.dhbin.beluga.service.SysUserRoleService;
import cn.dhbin.beluga.util.TreeUtil;
import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Service
@RequiredArgsConstructor
public class SysMenuServiceImpl extends MinionServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    private final SysUserRoleService sysUserRoleService;

    private final SysRoleMenuService sysRoleMenuService;

    private final SysMenuPermService sysMenuPermService;

    @Override
    public List<SysMenuDto> getTopMenuByUserId(Long userId) {
        List<SysUserRole> userRoleList = sysUserRoleService.getByUserId(userId);
        return userRoleList.stream()
                .map(sysUserRole -> sysRoleMenuService.getByRoleId(sysUserRole.getRid()))
                .flatMap(Collection::stream)
                .map(sysRoleMenu -> this.lambdaQuery()
                        .eq(SysMenu::getId, sysRoleMenu.getMid())
                        .eq(SysMenu::getType, MenuType.TOP_MENU)
                        .one()
                )
                .filter(Objects::nonNull)
                .map(sysMenu -> sysMenu.convert(SysMenuDto.class))
                .sorted(Comparator.comparingInt(SysMenuDto::getOrderNum))
                .collect(Collectors.toList());
    }

    @Override
    public List<SysMenuDto> getMenuTreeByUserId(Long userId, Integer parentId) {
        List<SysUserRole> userRoleList = sysUserRoleService.getByUserId(userId);

        List<SysMenuDto> sysMenus = userRoleList.stream()
                .map(sysUserRole -> sysRoleMenuService.getByRoleId(sysUserRole.getRid()))
                .flatMap(Collection::stream)
                .map(sysRoleMenu -> this.lambdaQuery()
                        .eq(SysMenu::getId, sysRoleMenu.getMid())
                        .eq(SysMenu::getType, MenuType.MENU)
                        .one()
                )
                .filter(Objects::nonNull)
                .map(sysMenu -> sysMenu.convert(SysMenuDto.class))
                .sorted(Comparator.comparingInt(SysMenuDto::getOrderNum))
                .collect(Collectors.toList());

        return TreeUtil.buildByLoop(sysMenus, parentId == null ? Constant.ROOT_MENU : parentId);
    }

    @Override
    public List<SysMenuDto> getByRoleId(Long roleId) {
        List<SysMenuDto> dtos = sysRoleMenuService.getByRoleId(roleId)
                .stream()
                .map(sysRoleMenu -> this.lambdaQuery().eq(SysMenu::getId, sysRoleMenu.getMid()).one())
                .map(sysMenu -> sysMenu.convert(SysMenuDto.class))
                .sorted(Comparator.comparingInt(SysMenuDto::getOrderNum))
                .collect(Collectors.toList());
        return TreeUtil.buildByLoop(dtos, Constant.ROOT_MENU);
    }

    @Override
    public List<SysMenuDto> getAllMenuTree() {
        List<SysMenuDto> menuDtos = this.lambdaQuery().list().stream()
                .map(sysMenu -> sysMenu.convert(SysMenuDto.class))
                .peek(sysMenuDto -> {
                    List<String> perms = this.sysMenuPermService.getByMenuId(sysMenuDto.getId()).stream().map(SysMenuPerm::getPid).collect(Collectors.toList());
                    sysMenuDto.setPerms(perms);
                })
                .sorted(Comparator.comparingInt(SysMenuDto::getOrderNum))
                .collect(Collectors.toList());
        return TreeUtil.buildByLoop(menuDtos, Constant.ROOT_MENU);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateMenu(SysMenu sysMenu, List<String> perms) {
        if (sysMenu.getParentNum() == null) {
            sysMenu.setParentNum(-1);
        }
        SysMenu originalSysMenu = this.getById(sysMenu.getId());
        // 更新子菜单的父num
        this.lambdaUpdate().eq(SysMenu::getParentNum, originalSysMenu.getNum())
                .set(SysMenu::getParentNum, sysMenu.getNum())
                .update();
        this.updateByIdAndReturn(sysMenu);
        this.sysMenuPermService.updateByMenuId(sysMenu.getId(), perms);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createMenu(SysMenu sysMenu, List<String> perms) {
        if (sysMenu.getParentNum() == null) {
            sysMenu.setParentNum(-1);
        }
        this.save(sysMenu);
        this.sysMenuPermService.updateByMenuId(sysMenu.getId(), perms);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeById(Serializable id) {
        this.sysMenuPermService.remove(new LambdaQueryWrapper<SysMenuPerm>().eq(SysMenuPerm::getMid, id));
        this.sysRoleMenuService.remove(new LambdaQueryWrapper<SysRoleMenu>().eq(SysRoleMenu::getMid, id));
        return super.removeById(id);
    }
}
