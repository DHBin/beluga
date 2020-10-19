package cn.dhbin.beluga.upms.model.enums;

import cn.dhbin.minion.core.common.response.IErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
@RequiredArgsConstructor
@Getter
public enum ErrorCode implements IErrorCode<Object> {

    /**
     * 用户已存在
     */
    USERNAME_EXITED(10_00_01, "用户已存在"),

    /**
     * 用户名或密码错误
     */
    LOGIN_FAILED(10_00_02, "用户名或密码错误"),

    /**
     * 验证码不正确
     */
    CAPTCHA_INVALID(10_00_03, "验证码不正确"),

    /**
     * 刷新token失败
     */
    REFRESH_TOKEN_ERROR(10_00_4, "刷新token失败"),

    /**
     * 字典类型已存在
     */
    SYS_DICT_TYPE_IS_EXIST(10_00_5, "字典类型已存在"),
    /**
     * 字典类型不存在
     */
    SYS_DICT_TYPE_IS_NOT_EXIST(10_00_6, "字典类型不存在"),
    /**
     * 字典项已经存在
     */
    SYS_DICT_ITEM_ITEM_VALUE_IS_EXIST(10_00_7, "字典项已经存在"),

    ;

    private final Integer status;

    private final String msg;


    @Override
    public Object convert() {
        return null;
    }
}
