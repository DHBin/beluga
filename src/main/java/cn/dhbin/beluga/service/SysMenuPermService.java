package cn.dhbin.beluga.service;

import cn.dhbin.beluga.entity.SysMenuPerm;
import cn.dhbin.minion.core.mybatis.service.IMinionService;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
public interface SysMenuPermService extends IMinionService<SysMenuPerm> {

    /**
     * 通过菜单id获取
     *
     * @param menuId 菜单id
     * @return sysMenuPerm
     */
    List<SysMenuPerm> getByMenuId(Long menuId);

    /**
     * 更新权限
     *
     * @param menuId 菜单id
     * @param perms  权限id
     */
    void updateByMenuId(Long menuId, List<String> perms);

}
