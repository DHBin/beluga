package cn.dhbin.beluga.config.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

/**
 * @author donghaibin
 * @date 2020/7/3
 */
public class TokenAuthentication extends AbstractAuthenticationToken {

    private final String token;

    public TokenAuthentication(String token) {
        super(null);
        this.token = token;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

}
