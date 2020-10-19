package cn.dhbin.beluga.upms.service.impl;

import cn.dhbin.beluga.upms.entity.SysDict;
import cn.dhbin.beluga.upms.entity.SysDictItem;
import cn.dhbin.beluga.upms.mapper.SysDictMapper;
import cn.dhbin.beluga.upms.model.enums.ErrorCode;
import cn.dhbin.beluga.upms.service.SysDictItemService;
import cn.dhbin.beluga.upms.service.SysDictService;
import cn.dhbin.minion.core.common.enums.ErrorCodeEnum;
import cn.dhbin.minion.core.mybatis.service.MinionServiceImpl;
import cn.dhbin.minion.core.restful.util.ApiAssert;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * <p>
 * 字典 服务实现类
 * </p>
 *
 * @author DHB
 * @since 2020-10-16
 */
@Service
public class SysDictServiceImpl extends MinionServiceImpl<SysDictMapper, SysDict> implements SysDictService {

    @Resource
    private SysDictItemService sysDictItemService;


    /**
     * 保存前先检查type是否已经存在，
     * 存在抛出{@link cn.dhbin.beluga.upms.model.enums.ErrorCode#SYS_DICT_TYPE_IS_EXIST}
     *
     * @param entity entity
     * @return 是否成功
     */
    @Override
    public boolean save(SysDict entity) {
        SysDict one = this.lambdaQuery().eq(SysDict::getType, entity.getType()).one();
        ApiAssert.isNull(ErrorCode.SYS_DICT_TYPE_IS_EXIST, one);
        return super.save(entity);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeByIdWithItem(Serializable id) {
        if (id == null) {
            ApiAssert.failure(ErrorCodeEnum.BAD_REQUEST);
        }
        this.sysDictItemService.lambdaUpdate().eq(SysDictItem::getDictId, id).remove();
        this.removeById(id);
    }

}
