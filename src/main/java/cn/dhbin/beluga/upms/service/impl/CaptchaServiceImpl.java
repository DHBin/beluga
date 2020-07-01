package cn.dhbin.beluga.upms.service.impl;

import cn.dhbin.beluga.upms.service.CaptchaService;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import static cn.dhbin.beluga.config.Constant.CODE_KEY_PREFIX;

/**
 *
 * @author donghaibin
 */
@Service
@RequiredArgsConstructor
public class CaptchaServiceImpl implements CaptchaService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean valid(String rand, String code) {
        String codeInRedis = (String) redisTemplate.opsForValue().get(CODE_KEY_PREFIX + rand);
        return StrUtil.equalsAnyIgnoreCase(code, codeInRedis);
    }
}
