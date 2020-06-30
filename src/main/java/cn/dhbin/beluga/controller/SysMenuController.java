package cn.dhbin.beluga.controller;

import cn.dhbin.beluga.entity.SysMenu;
import cn.dhbin.beluga.model.dto.SysMenuDto;
import cn.dhbin.beluga.model.param.SysMenuParam;
import cn.dhbin.beluga.model.param.UpdateRoleMenuParam;
import cn.dhbin.beluga.service.SysMenuService;
import cn.dhbin.beluga.service.SysRoleMenuService;
import cn.dhbin.beluga.service.SysUserService;
import cn.dhbin.beluga.util.SecurityUtil;
import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/3/12
 */
@RestController
@RequestMapping("/menu")
@RequiredArgsConstructor
public class SysMenuController extends RestfulController {

    private final StringRedisTemplate redisTemplate;

    private static final String TOP_MENU_KEY = "upms::topMenu";

    private static final String MENU_KEY = "upms::menu";

    private final SysMenuService sysMenuService;

    private final SysUserService sysUserService;

    private final SysRoleMenuService sysRoleMenuService;


    @GetMapping("/getTopMenu")
    @ApiOperation(value = "获取顶部菜单")
    public ApiResponse<?> getTopMenu() {
        List<SysMenuDto> sysMenuDtos = sysMenuService.getTopMenuByUserId(SecurityUtil.getUserId());
        return ok(sysMenuDtos);
    }

    @GetMapping("/getMenu")
    @ApiOperation(value = "获取左侧菜单")
    public ApiResponse<?> getMenu(@RequestParam(required = false, defaultValue = "-1") Integer parentId) {
        List<SysMenuDto> sysMenuDtos = sysMenuService.getMenuTreeByUserId(SecurityUtil.getUserId(), parentId);
        return ok(sysMenuDtos);
    }

    @GetMapping
    @ApiOperation(value = "获取所有菜单", authorizations = @Authorization("sys_menu_list"))
    @PreAuthorize("hasAuthority('sys_menu_list')")
    public ApiResponse<List<SysMenuDto>> all() {
        List<SysMenuDto> allMenuTree = this.sysMenuService.getAllMenuTree();
        return success(allMenuTree);
    }

    @GetMapping("/role")
    @ApiOperation(value = "获取角色的菜单", authorizations = @Authorization("sys_menu_role_get"))
    @PreAuthorize("hasAuthority('sys_menu_role_get')")
    public ApiResponse<List<SysMenuDto>> getRoleMenuId(Long roleId) {
        List<SysMenuDto> menuDtos = this.sysMenuService.getByRoleId(roleId);
        return success(menuDtos);
    }

    @PutMapping("/role")
    @ApiOperation(value = "更新角色的菜单", authorizations = @Authorization("sys_menu_role_update"))
    @PreAuthorize("hasAuthority('sys_menu_role_update')")
    public ApiResponse<?> updateRoleMenu(@Validated @RequestBody UpdateRoleMenuParam param) {
        this.sysRoleMenuService.updateRoleMenu(param.getRoleId(), param.getMenuIds());
        return created();
    }

    @PutMapping
    @ApiOperation(value = "更新菜单", authorizations = @Authorization("sys_menu_update"))
    @PreAuthorize("hasAuthority('sys_menu_update')")
    public ApiResponse<?> update(@Validated(SysMenuParam.Update.class) @RequestBody SysMenuParam sysMenuParam) {
        this.sysMenuService.updateMenu(sysMenuParam.convert(SysMenu.class), sysMenuParam.getPerms());
        return created();
    }

    @PostMapping
    @ApiOperation(value = "创建菜单", authorizations = @Authorization("sys_menu_create"))
    @PreAuthorize("hasAuthority('sys_menu_create')")
    public ApiResponse<?> create(@Validated(SysMenuParam.Create.class) @RequestBody SysMenuParam sysMenuParam) {
        this.sysMenuService.createMenu(sysMenuParam.convert(SysMenu.class), sysMenuParam.getPerms());
        return created();
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation(value = "删除菜单", authorizations = @Authorization("sys_menu_delete"))
    @PreAuthorize("hasAuthority('sys_menu_delete')")
    public ApiResponse<?> delete(@PathVariable Long id) {
        this.sysMenuService.removeById(id);
        return created();
    }
}
