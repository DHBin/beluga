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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PermUser permUser = (PermUser) authentication.getCredentials();
        return permUser.getUserId();
    }

}
