package cn.dhbin.beluga.upms.manager;

/**
 * @author donghaibin
 */
public interface CaptchaManager {

    /**
     * 保存验证码信息
     *
     * @param rand 随机码
     * @param code 验证码
     */
    void put(String rand, String code);

    /**
     * 获取验证码，获取不到返回null
     *
     * @param rand 随机码
     * @return 验证码
     */
    String getAndDelete(String rand);

}
