package cn.dhbin.beluga.upms.manager.impl;

import cn.dhbin.beluga.upms.config.UpmsConstant;
import cn.dhbin.beluga.upms.manager.CaptchaManager;
import cn.dhbin.beluga.util.CacheUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * @author donghaibin
 * @date 2020/7/7
 */
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "spring.cache", name = "type", havingValue = "redis")
@Component
public class RedisCaptchaManagerImpl implements CaptchaManager {

    private final RedisTemplate<String, Object> redisTemplate;


    @Override
    public void put(String rand, String code) {
        String cacheKey = CacheUtil.buildCacheKey(UpmsConstant.CODE_KEY_PREFIX, rand);
        redisTemplate.opsForValue().set(cacheKey, code, Duration.ofSeconds(UpmsConstant.CAPTCHA_TIMEOUT_TIME));
    }

    @Override
    public String getAndDelete(String rand) {
        String cacheKey = CacheUtil.buildCacheKey(UpmsConstant.CODE_KEY_PREFIX, rand);
        Object o = redisTemplate.opsForValue().get(cacheKey);
        return o == null ? null : (String) o;
    }

}
