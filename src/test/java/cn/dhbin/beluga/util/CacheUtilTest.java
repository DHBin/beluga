package cn.dhbin.beluga.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheUtilTest {

    @Test
    void buildCacheKey() {
        String cacheKey = CacheUtil.buildCacheKey("a", "b");
        assertEquals("a::b", cacheKey);
    }

}