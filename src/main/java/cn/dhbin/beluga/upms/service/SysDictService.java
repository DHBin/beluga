package cn.dhbin.beluga.upms.service;

import cn.dhbin.beluga.upms.entity.SysDict;
import cn.dhbin.minion.core.mybatis.service.IMinionService;

import java.io.Serializable;

/**
 * <p>
 * 字典 服务类
 * </p>
 *
 * @author DHB
 * @since 2020-10-16
 */
public interface SysDictService extends IMinionService<SysDict> {

    /**
     * 删除字典以及字典项
     *
     * @param id id
     */
    void removeByIdWithItem(Serializable id);

}
