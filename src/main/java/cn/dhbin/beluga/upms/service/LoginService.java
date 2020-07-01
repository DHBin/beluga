package cn.dhbin.beluga.upms.service;

import cn.dhbin.beluga.upms.exception.LoginFailedException;
import cn.dhbin.beluga.upms.model.PermUser;
import org.springframework.lang.Nullable;

/**
 * 用户登录
 *
 * @author donghaibin
 * @date 2020/7/1
 */
public interface LoginService {

    /**
     * 用户登录，登录成功返回用户权限信息
     *
     * @param username 用户名
     * @param password 密码（明文）
     * @return Token
     * @throws LoginFailedException 登录失败
     */
    String login(String username, String password) throws LoginFailedException;

    /**
     * 从已登录用户列表中获取{@link PermUser}，如果不存在返回Null
     *
     * @param token token
     * @return 是否登录
     */
    @Nullable
    PermUser getPermUser(String token);

    /**
     * 登出，移除缓存中的登录信息
     *
     * @param token token
     */
    void logout(String token);

}
