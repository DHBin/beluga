package cn.dhbin.beluga.upms.config;

/**
 * 用户管理模块常量
 *
 * @author donghaibin
 * @date 2020/7/2
 */
public interface UpmsConstant {


    /**
     * 用户管理模块前缀
     */
    String UMPS_PREFIX = "/upms";

    /**
     * 菜单根目录编码
     */
    Integer ROOT_MENU = -1;

    /**
     * Token有效期
     */
    long AUTH_PERIOD_OF_VALIDITY = 7200L;

    /**
     * key 用于获取{@link org.springframework.cache.Cache}以及配置缓存信息
     */
    String AUTH_KEY_PREFIX = "auth";

    /**
     * 验证码缓存key前缀
     */
    String CODE_KEY_PREFIX = "code_key";

    /**
     * 验证码宽度
     */
    int CAPTCHA_WIDTH = 130;

    /**
     * 验证码高度
     */
    int CAPTCHA_HEIGHT = 48;

    /**
     * 验证码有效期60秒
     */
    long CAPTCHA_TIMEOUT_TIME = 60;

}
