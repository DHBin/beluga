package cn.dhbin.beluga.util;

import org.springframework.aop.framework.AopContext;

/**
 * @author donghaibin
 * @date 2020/7/3
 */
public class AopUtil {

    public static <T> T getCurrentProxy(Class<T> type) {
        return type.cast(AopContext.currentProxy());
    }

}
