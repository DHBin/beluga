package cn.dhbin.beluga.config;

/**
 * @author donghaibin
 * @date 2020/3/20
 */
public interface Constant {

    /**
     * 菜单根目录编码
     */
    Integer ROOT_MENU = -1;

    String HTTP_HEADER_JSON_UTF8 = "application/json;charset=UTF-8";

    /**
     * 认证信息有效期
     */
    long AUTH_PERIOD_OF_VALIDITY = 7200L;

    /**
     * key 用于获取{@link org.springframework.cache.Cache}以及配置缓存信息
     */
    String AUTH_KEY_NAME = "auth";

    /**
     * 验证码缓存key前缀
     */
    String CODE_KEY_PREFIX = "code_key::";

    /**
     * 用户管理模块前缀
     */
    String UMPS_PREFIX = "/upms";
}
