package cn.dhbin.beluga.upms.service;

/**
 * 验证码
 *
 * @author donghaibin
 */
public interface CaptchaService {

    /**
     * 验证码验证，通过rand从redis中取出code对比验证
     *
     * @param rand 随机码
     * @param code 验证码
     * @return 是否匹配
     */
    boolean valid(String rand, String code);
}
