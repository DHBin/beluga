package cn.dhbin.beluga.upms.manager.impl;

import cn.dhbin.beluga.upms.config.UpmsConstant;
import cn.dhbin.beluga.upms.manager.TokenManager;
import cn.dhbin.beluga.upms.model.PermUser;
import cn.dhbin.beluga.util.CacheUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author donghaibin
 * @date 2020/7/7
 */
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "spring.cache", name = "type", havingValue = "redis")
@Component
public class RedisPermUserTokenManager implements TokenManager<PermUser> {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void save(String token, PermUser detail) {
        String cacheKey = CacheUtil.buildCacheKey(UpmsConstant.AUTH_KEY_PREFIX, token);
        redisTemplate.opsForValue().set(cacheKey, detail, UpmsConstant.AUTH_PERIOD_OF_VALIDITY, TimeUnit.SECONDS);
    }

    @Override
    public PermUser load(String token) {
        String cacheKey = CacheUtil.buildCacheKey(UpmsConstant.AUTH_KEY_PREFIX, token);
        return (PermUser) redisTemplate.opsForValue().get(cacheKey);
    }

    @Override
    public void remove(String token) {
        String cacheKey = CacheUtil.buildCacheKey(UpmsConstant.AUTH_KEY_PREFIX, token);
        redisTemplate.delete(cacheKey);
    }
}
