package cn.dhbin.beluga.upms.manager.impl;

import cn.dhbin.beluga.upms.config.UpmsConstant;
import cn.dhbin.beluga.upms.manager.CaptchaManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author donghaibin
 * @date 2020/7/7
 */
@Component
@ConditionalOnProperty(prefix = "spring.cache", name = "type", havingValue = "ehcache")
@RequiredArgsConstructor
public class EhcacheCaptchaManagerImpl implements CaptchaManager {

    private final CacheManager cacheManager;

    private Cache cache;


    @PostConstruct
    public void init() {
        cache = cacheManager.getCache(UpmsConstant.CODE_KEY_PREFIX);
    }

    @Override
    public void put(String rand, String code) {
        cache.put(rand, code);
    }

    @Override
    public String getAndDelete(String rand) {
        return cache.get(rand, String.class);
    }

}
