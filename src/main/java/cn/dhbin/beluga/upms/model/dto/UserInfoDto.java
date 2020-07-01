package cn.dhbin.beluga.upms.model.dto;

import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author donghaibin
 * @date 2020/6/30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfoDto implements Convert {


    /**
     * 用户id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 权限
     */
    private List<String> authorities;

    /**
     * 角色
     */
    private List<String> roles;


}
