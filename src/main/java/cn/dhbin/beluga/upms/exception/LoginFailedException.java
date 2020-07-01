package cn.dhbin.beluga.upms.exception;

/**
 * 登录失败异常
 *
 * @author donghaibin
 * @date 2020/7/1
 */
public class LoginFailedException extends Exception {

    public LoginFailedException(String msg) {
        super(msg);
    }

}
