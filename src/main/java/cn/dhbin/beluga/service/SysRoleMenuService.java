package cn.dhbin.beluga.service;

import cn.dhbin.beluga.entity.SysRoleMenu;
import cn.dhbin.minion.core.mybatis.service.IMinionService;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
public interface SysRoleMenuService extends IMinionService<SysRoleMenu> {

    /**
     * 获取角色-菜单关联信息
     *
     * @param roleId 角色id
     * @return 角色-菜单关联信息
     */
    List<SysRoleMenu> getByRoleId(Long roleId);

    /**
     * 更新角色菜单
     *
     * @param roleId  角色id
     * @param menuIds 菜单ids
     */
    void updateRoleMenu(Long roleId, List<Long> menuIds);

}
