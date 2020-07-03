package cn.dhbin.beluga.util;

import cn.dhbin.beluga.upms.model.PermUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author donghaibin
 * @date 2020/6/30
 */
public class SecurityUtil {

    public static Long getUserId() {
        PermUser permUser = getCurrentPermUser();
        return permUser.getId();
    }

    /**
     * 获取当前PermUser，包含token，用户名、权限等信息
     *
     * @return 当前PermUser
     */
    public static PermUser getCurrentPermUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (PermUser) authentication.getPrincipal();
    }


}
