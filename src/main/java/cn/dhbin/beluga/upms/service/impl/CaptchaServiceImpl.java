package cn.dhbin.beluga.upms.service.impl;

import cn.dhbin.beluga.upms.config.UpmsConstant;
import cn.dhbin.beluga.upms.service.CaptchaService;
import cn.dhbin.beluga.util.CacheUtil;
import cn.hutool.core.util.StrUtil;
import com.wf.captcha.ArithmeticCaptcha;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @author donghaibin
 */
@Service
@RequiredArgsConstructor
public class CaptchaServiceImpl implements CaptchaService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public ArithmeticCaptcha createCaptcha(String rand) {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(UpmsConstant.CAPTCHA_WIDTH, UpmsConstant.CAPTCHA_HEIGHT);
        String text = captcha.text();
        String cacheKey = CacheUtil.buildCacheKey(UpmsConstant.CODE_KEY_PREFIX, rand);
        redisTemplate.opsForValue().set(cacheKey, text, Duration.ofSeconds(UpmsConstant.CAPTCHA_TIMEOUT_TIME));
        return captcha;
    }

    @Override
    public boolean valid(String rand, String code) {
        String cacheKey = CacheUtil.buildCacheKey(UpmsConstant.CODE_KEY_PREFIX, rand);
        String codeInRedis = (String) redisTemplate.opsForValue().get(cacheKey);
        redisTemplate.delete(cacheKey);
        return StrUtil.equalsAnyIgnoreCase(code, codeInRedis);
    }
}
