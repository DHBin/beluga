package cn.dhbin.beluga.upms.controller;


import cn.dhbin.beluga.upms.entity.SysDict;
import cn.dhbin.beluga.upms.model.dto.SysDictDto;
import cn.dhbin.beluga.upms.model.param.SysDictParam;
import cn.dhbin.beluga.upms.model.query.SysDictQuery;
import cn.dhbin.beluga.upms.service.SysDictService;
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

/**
 * <p>
 * 字典 前端控制器
 * </p>
 *
 * @author DHB
 * @since 2020-10-16
 */
@RestController
@RequestMapping("/upms/sysDict")
@RequiredArgsConstructor
@Api(tags = "字典")
public class SysDictController extends RestfulController {

    private final SysDictService sysDictService;

    /**
     * 分页获取
     */
    @GetMapping
    @ApiOperation(value = "分页获取 字典", authorizations = @Authorization("SYS_DICT_page"))
    @PreAuthorize("hasAuthority('SYS_DICT_page')")
    public ApiResponse<?> page(PageModel<SysDict> pageModel, SysDictQuery query) {
        IPage<SysDictDto> record = this.sysDictService
                .page(pageModel.convert(), Wrappers.lambdaQuery(query.convert(SysDict.class)))
                .convert(sysDict -> sysDict.convert(SysDictDto.class));
        return ok(record);
    }

    /**
     * 新建
     */
    @PostMapping
    @ApiOperation(value = "新建字典", authorizations = @Authorization("SYS_DICT_create"))
    @PreAuthorize("hasAuthority('SYS_DICT_create')")
    public ApiResponse<?> create(@Validated @RequestBody SysDictParam param) {
        param.setId(null);
        this.sysDictService.save(param.convert(SysDict.class));
        return created();
    }

    /**
     * 删除
     */
    @DeleteMapping("{id:\\d+}")
    @ApiOperation(value = "删除字典", authorizations = @Authorization("SYS_DICT_delete"))
    @PreAuthorize("hasAuthority('SYS_DICT_delete')")
    public ApiResponse<?> delete(@PathVariable Long id) {
        this.sysDictService.removeByIdWithItem(id);
        return noContent();
    }

    /**
     * 更新
     */
    @PutMapping
    @ApiOperation(value = "更新字典", authorizations = @Authorization("SYS_DICT_update"))
    @PreAuthorize("hasAuthority('SYS_DICT_update')")
    public ApiResponse<?> update(@Validated @RequestBody SysDictParam param) {
        param.setType(null);
        this.sysDictService.updateByIdAndReturn(param.convert(SysDict.class));
        return created();
    }

    /**
     * 通过id获取
     *
     * @param id 主键
     */
    @GetMapping("{id:\\d+}")
    @ApiOperation(value = "通过id获取字典", authorizations = @Authorization("SYS_DICT_retrieve"))
    @PreAuthorize("hasAuthority('SYS_DICT_retrieve')")
    public ApiResponse<?> retrieve(@PathVariable("id") Long id) {
        return ok(this.sysDictService.getById(id));
    }

}

