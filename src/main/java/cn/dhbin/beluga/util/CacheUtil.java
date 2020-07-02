package cn.dhbin.beluga.util;

/**
 * Cache
 *
 * @author donghaibin
 * @date 2020/7/2
 */
public class CacheUtil {

    private static final String CACHE_DELIMITER = "::";

    /**
     * 创建cache key
     *
     * @param prefix 前缀 （name）
     * @param suffix 后缀
     * @return key
     */
    public static String buildCacheKey(String prefix, String suffix) {
        return prefix + CACHE_DELIMITER + suffix;
    }

}
