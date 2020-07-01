package cn.dhbin.beluga.upms.controller;

import com.wf.captcha.ArithmeticCaptcha;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;

import static cn.dhbin.beluga.config.Constant.CODE_KEY_PREFIX;

/**
 * @author donghaibin
 * @date 2020/7/1
 */
@Controller
@RequestMapping("/code")
@RequiredArgsConstructor
public class CaptchaController {

    private final RedisTemplate<String, Object> redisTemplate;

    /**
     * 验证码宽度
     */
    private static final int CAPTCHA_WIDTH = 130;

    /**
     * 验证码高度
     */
    private static final int CAPTCHA_HEIGHT = 48;

    /**
     * 验证码有效期60秒
     */
    private static final long CAPTCHA_TIMEOUT_TIME = 60;

    @GetMapping
    public void code(String rand, HttpServletResponse httpServletResponse) throws IOException {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(CAPTCHA_WIDTH, CAPTCHA_HEIGHT);
        String text = captcha.text();
        redisTemplate.opsForValue().set(CODE_KEY_PREFIX + rand, text, Duration.ofSeconds(CAPTCHA_TIMEOUT_TIME));
        httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE);
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        captcha.out(outputStream);
    }

}
