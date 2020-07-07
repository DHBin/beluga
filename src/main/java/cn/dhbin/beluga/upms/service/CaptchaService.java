package cn.dhbin.beluga.upms.service;

import com.wf.captcha.ArithmeticCaptcha;

/**
 * 验证码
 *
 * @author donghaibin
 */
public interface CaptchaService {


    /**
     * 创建验证码，把验证码保存在redis中，有效期为{@link cn.dhbin.beluga.upms.config.UpmsConstant#AUTH_PERIOD_OF_VALIDITY}
     *
     * @param rand 随机值
     * @return {@link ArithmeticCaptcha}
     */
    ArithmeticCaptcha createCaptcha(String rand);

    /**
     * 验证码验证，通过rand从redis中取出code对比验证
     *
     * @param rand       随机码
     * @param expectCode 期望值
     * @return 是否匹配
     */
    boolean valid(String rand, String expectCode);
}
