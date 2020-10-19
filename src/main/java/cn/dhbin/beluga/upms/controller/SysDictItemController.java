package cn.dhbin.beluga.upms.controller;


import cn.dhbin.beluga.upms.entity.SysDictItem;
import cn.dhbin.beluga.upms.model.dto.SysDictItemDto;
import cn.dhbin.beluga.upms.model.param.SysDictItemParam;
import cn.dhbin.beluga.upms.model.query.SysDictItemQuery;
import cn.dhbin.beluga.upms.service.SysDictItemService;
import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * <p>
 * 字典项 前端控制器
 * </p>
 *
 * @author DHB
 * @since 2020-10-16
 */
@RestController
@RequestMapping("/upms/sysDictItem")
@RequiredArgsConstructor
@Api(tags = "字典项")
public class SysDictItemController extends RestfulController {

        private final SysDictItemService sysDictItemService;

        /**
         * 分页获取
         */
        @GetMapping
        @ApiOperation(value = "分页获取 字典项", authorizations = @Authorization("SYS_DICT_ITEM_page"))
        @PreAuthorize("hasAuthority('SYS_DICT_ITEM_page')")
        public ApiResponse<?> page(PageModel<SysDictItem> pageModel, SysDictItemQuery query) {
                IPage<SysDictItemDto> record = this.sysDictItemService
                        .page(pageModel.convert(), Wrappers.lambdaQuery(query.convert(SysDictItem.class)))
                        .convert(sysDictItem -> sysDictItem.convert(SysDictItemDto.class));
                // 排序
                record.setRecords(record.getRecords().stream()
                        .sorted(Comparator.comparingInt(SysDictItemDto::getSortNum))
                        .collect(Collectors.toList()));
                return ok(record);
        }

        /**
         * 新建
         */
        @PostMapping
        @ApiOperation(value = "新建字典项", authorizations = @Authorization("SYS_DICT_ITEM_create"))
        @PreAuthorize("hasAuthority('SYS_DICT_ITEM_create')")
        public ApiResponse<?> create(@Validated @RequestBody SysDictItemParam param) {
                param.setId(null);
                this.sysDictItemService.save(param.convert(SysDictItem.class));
                return created();
        }

        /**
         * 删除
         */
        @DeleteMapping("{id:\\d+}")
        @ApiOperation(value = "删除字典项", authorizations = @Authorization("SYS_DICT_ITEM_delete"))
        @PreAuthorize("hasAuthority('SYS_DICT_ITEM_delete')")
        public ApiResponse<?> delete(@PathVariable Long id) {
                this.sysDictItemService.removeById(id);
                return noContent();
        }

        /**
         * 更新
         */
        @PutMapping
        @ApiOperation(value = "更新字典项", authorizations = @Authorization("SYS_DICT_ITEM_update"))
        @PreAuthorize("hasAuthority('SYS_DICT_ITEM_update')")
        public ApiResponse<?> update(@Validated @RequestBody SysDictItemParam param) {
                param.setDictId(null);
                this.sysDictItemService.updateByIdAndReturn(param.convert(SysDictItem.class));
                return created();
        }

        /**
         * 通过id获取
         *
         * @param id 主键
         */
        @GetMapping("{id:\\d+}")
        @ApiOperation(value = "通过id获取字典项", authorizations = @Authorization("SYS_DICT_ITEM_retrieve"))
        @PreAuthorize("hasAuthority('SYS_DICT_ITEM_retrieve')")
        public ApiResponse<?> retrieve(@PathVariable("id") Long id) {
                return ok(this.sysDictItemService.getById(id));
        }

        /**
         * 通过字典类型获取字典项
         *
         * @param dictType 字典名
         * @return {@link SysDictItemDto}
         */
        @GetMapping("queryByDictName")
        @ApiOperation(value = "通过字典类型获取字典项")
        public ApiResponse<?> queryByDictName(String dictType) {
                return ok(this.sysDictItemService.queryByDictType(dictType));
        }

}

