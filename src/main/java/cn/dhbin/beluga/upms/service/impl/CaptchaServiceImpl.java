package cn.dhbin.beluga.upms.service.impl;

import cn.dhbin.beluga.upms.config.UpmsConstant;
import cn.dhbin.beluga.upms.manager.CaptchaManager;
import cn.dhbin.beluga.upms.service.CaptchaService;
import cn.hutool.core.util.StrUtil;
import com.wf.captcha.ArithmeticCaptcha;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author donghaibin
 */
@Service
@RequiredArgsConstructor
public class CaptchaServiceImpl implements CaptchaService {

    private final CaptchaManager captchaManager;

    @Override
    public ArithmeticCaptcha createCaptcha(String rand) {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(UpmsConstant.CAPTCHA_WIDTH, UpmsConstant.CAPTCHA_HEIGHT);
        String text = captcha.text();
        captchaManager.put(rand, text);
        return captcha;
    }

    @Override
    public boolean valid(String rand, String expectCode) {
        String code = captchaManager.getAndDelete(rand);
        return StrUtil.equalsAnyIgnoreCase(expectCode, code);
    }
}
