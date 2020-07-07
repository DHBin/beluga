package cn.dhbin.beluga.upms.manager.impl;

import cn.dhbin.beluga.upms.config.UpmsConstant;
import cn.dhbin.beluga.upms.manager.TokenManager;
import cn.dhbin.beluga.upms.model.PermUser;
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
public class EhcachePermUserTokenManager implements TokenManager<PermUser> {

    private final CacheManager cacheManager;

    private Cache cache;


    @PostConstruct
    public void init() {
        cache = cacheManager.getCache(UpmsConstant.AUTH_KEY_PREFIX);
    }


    @Override
    public void save(String token, PermUser detail) {
        cache.put(token, detail);
    }

    @Override
    public PermUser load(String token) {
        return cache.get(token, PermUser.class);
    }

    @Override
    public void remove(String token) {
        cache.evict(token);
    }

}
