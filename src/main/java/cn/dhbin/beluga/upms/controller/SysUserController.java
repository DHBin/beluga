package cn.dhbin.beluga.upms.controller;

import cn.dhbin.beluga.upms.config.UpmsConstant;
import cn.dhbin.beluga.upms.entity.SysUser;
import cn.dhbin.beluga.upms.exception.LoginFailedException;
import cn.dhbin.beluga.upms.model.PermUser;
import cn.dhbin.beluga.upms.model.dto.UserDto;
import cn.dhbin.beluga.upms.model.dto.UserInfoDto;
import cn.dhbin.beluga.upms.model.enums.ErrorCode;
import cn.dhbin.beluga.upms.model.param.SysUserParam;
import cn.dhbin.beluga.upms.service.CaptchaService;
import cn.dhbin.beluga.upms.service.LoginService;
import cn.dhbin.beluga.upms.service.SysUserService;
import cn.dhbin.beluga.util.SecurityUtil;
import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.dhbin.minion.core.mybatis.model.PageModel;
import cn.dhbin.minion.core.restful.config.props.MinionConfigProperties;
import cn.dhbin.minion.core.restful.controller.RestfulController;
import cn.dhbin.minion.core.restful.util.ApiAssert;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

/**
 * @author donghaibin
 * @date 2020/1/4
 */
@RestController
@RequestMapping(UpmsConstant.UMPS_PREFIX + "/user")
@RequiredArgsConstructor
@Api(tags = "用户")
@Slf4j
@Validated
public class SysUserController extends RestfulController {

    private final SysUserService sysUserService;

    private final LoginService loginService;

    private final CaptchaService captchaService;

    private final MinionConfigProperties configProperties;

    @GetMapping("getUserInfo")
    @ApiOperation(value = "获取当前用户信息")
    public ApiResponse<UserInfoDto> getUserInfo() {
        PermUser currentPermUser = SecurityUtil.getCurrentPermUser();
        UserInfoDto userInfoDto = currentPermUser.convert(UserInfoDto.class);
        return ok(userInfoDto);
    }

    @PostMapping("/login")
    @ApiOperation(value = "用户登录", notes = "开发环境默认关闭验证码")
    public ApiResponse<?> login(@NotBlank(message = "用户名不能为空") @ApiParam("用户名") String username,
                                @NotBlank(message = "密码不能为空") @ApiParam("密码") String password,
                                @RequestParam(value = "r", required = false) @ApiParam(value = "随机值") String randomStr,
                                @RequestParam(required = false) @ApiParam(value = "验证码") String code) {
        boolean valid = configProperties.getDev() || captchaService.valid(randomStr, code);
        ApiAssert.isTrue(ErrorCode.CAPTCHA_INVALID, valid);
        try {
            String token = loginService.login(username, password);
            return ok(token);
        } catch (LoginFailedException e) {
            log.info(e.getMessage());
            return ApiResponse.fail(ErrorCode.LOGIN_FAILED);
        }
    }

    @PostMapping("/refreshToken")
    @ApiOperation(value = "刷新token", notes = "执行成功后，旧的token失效")
    public ApiResponse<?> refreshToken() {
        PermUser currentPermUser = SecurityUtil.getCurrentPermUser();
        PermUser newPermUser = this.loginService.refreshToken(currentPermUser.getToken());
        if (newPermUser == null) {
            return ApiResponse.fail(ErrorCode.REFRESH_TOKEN_ERROR);
        } else {
            return ok(newPermUser.getToken());
        }
    }

    @GetMapping("/logout")
    @ApiOperation(value = "登出")
    public ApiResponse<?> logout() {
        PermUser currentPermUser = SecurityUtil.getCurrentPermUser();
        loginService.logout(currentPermUser.getToken());
        return ok();
    }

    @GetMapping
    @ApiOperation(value = "获取用户列表", authorizations = @Authorization("sys_user_list"))
    @PreAuthorize("hasAuthority('sys_user_list')")
    public ApiResponse<IPage<UserDto>> list(PageModel<SysUser> page) {
        return success(this.sysUserService.list(page));
    }

    @PutMapping
    @ApiOperation(value = "更新用户", authorizations = @Authorization("sys_user_update"))
    @PreAuthorize("hasAuthority('sys_user_update')")
    public ApiResponse<?> update(@Validated(SysUserParam.Update.class) @RequestBody SysUserParam sysUserParam) {
        SysUser sysUser = sysUserParam.convert(SysUser.class);
        this.sysUserService.updateUser(sysUser, sysUserParam.getRoles());
        return created();
    }

    @PostMapping
    @ApiOperation(value = "创建用户", authorizations = @Authorization("sys_user_create"))
    @PreAuthorize("hasAuthority('sys_user_create')")
    public ApiResponse<?> create(@Validated(SysUserParam.Create.class) @RequestBody SysUserParam sysUserParam) {
        SysUser sysUser = sysUserParam.convert(SysUser.class);
        this.sysUserService.createUser(sysUser, sysUserParam.getRoles());
        return created();
    }

    @DeleteMapping("/{id:\\d+}")
    @ApiOperation(value = "删除用户", authorizations = @Authorization("sys_user_delete"))
    @PreAuthorize("hasAuthority('sys_user_delete')")
    public ApiResponse<?> delete(@PathVariable Long id) {
        return created(this.sysUserService.removeById(id));
    }

    @PostMapping("/changePassword")
    @ApiOperation(value = "修改密码")
    public ApiResponse<?> changePassword(@Validated @NotBlank(message = "新密码不能为空") String newPassword) {
        this.sysUserService.changePassword(SecurityUtil.getCurrentPermUser().getUsername(), newPassword);
        return created();
    }

}
