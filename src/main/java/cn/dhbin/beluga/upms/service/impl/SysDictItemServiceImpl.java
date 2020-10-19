package cn.dhbin.beluga.upms.service.impl;

import cn.dhbin.beluga.upms.entity.SysDict;
import cn.dhbin.beluga.upms.entity.SysDictItem;
import cn.dhbin.beluga.upms.mapper.SysDictItemMapper;
import cn.dhbin.beluga.upms.model.dto.SysDictItemDto;
import cn.dhbin.beluga.upms.model.enums.ErrorCode;
import cn.dhbin.beluga.upms.service.SysDictItemService;
import cn.dhbin.beluga.upms.service.SysDictService;
import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.core.restful.util.ApiAssert;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 字典项 服务实现类
 * </p>
 *
 * @author DHB
 * @since 2020-10-16
 */
@Service
public class SysDictItemServiceImpl extends MinionServiceImpl<SysDictItemMapper, SysDictItem> implements SysDictItemService {

    @Resource
    private SysDictService sysDictService;


    /**
     * 保存前先检查item_value是否已经存在，
     * 存在抛出{@link cn.dhbin.beluga.upms.model.enums.ErrorCode#SYS_DICT_ITEM_ITEM_VALUE_IS_EXIST}
     *
     * @param entity entity
     * @return 是否成功
     */
    @Override
    public boolean save(SysDictItem entity) {
        SysDictItem one = this.lambdaQuery().select(SysDictItem::getId)
                .eq(SysDictItem::getItemValue, entity.getItemValue())
                .eq(SysDictItem::getDictId, entity.getDictId())
                .one();
        ApiAssert.isNull(ErrorCode.SYS_DICT_ITEM_ITEM_VALUE_IS_EXIST, one);
        return super.save(entity);
    }

    @Override
    public List<SysDictItemDto> queryByDictType(String dictName) {
        SysDict sysDict = this.sysDictService.lambdaQuery().select(SysDict::getId).eq(SysDict::getType, dictName).one();
        ApiAssert.notNull(ErrorCode.SYS_DICT_TYPE_IS_NOT_EXIST, sysDict);

        return this.lambdaQuery().eq(SysDictItem::getDictId, sysDict.getId())
                .list()
                .stream()
                .map(sysDictItem -> sysDictItem.convert(SysDictItemDto.class))
                .sorted(Comparator.comparingInt(SysDictItemDto::getSortNum))
                .collect(Collectors.toList());
    }
}
