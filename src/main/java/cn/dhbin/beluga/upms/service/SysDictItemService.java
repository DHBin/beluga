package cn.dhbin.beluga.upms.service;

import cn.dhbin.beluga.upms.entity.SysDictItem;
import cn.dhbin.beluga.upms.model.dto.SysDictItemDto;
import cn.dhbin.minion.core.mybatis.service.IMinionService;

import java.util.List;

/**
 * <p>
 * 字典项 服务类
 * </p>
 *
 * @author DHB
 * @since 2020-10-16
 */
public interface SysDictItemService extends IMinionService<SysDictItem> {

    /**
     * 通过字典名字获取字典项
     *
     * @param dictName 字典名
     * @return 字典项集合
     */
    List<SysDictItemDto> queryByDictType(String dictName);

}
