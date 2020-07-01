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
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 权限
     */
    private List<String> perms;

}
