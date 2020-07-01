package cn.dhbin.beluga.upms.model;

import cn.dhbin.minion.core.tool.converter.Convert;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 用户权限信息
 *
 * @author donghaibin
 * @date 2020/7/1
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PermUser implements Convert {

    /**
     * token
     */
    private String token;

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
