package cn.dhbin.beluga.config.security;

import cn.dhbin.beluga.upms.model.PermUser;
import cn.dhbin.beluga.upms.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/7/3
 */
@RequiredArgsConstructor
@Component
public class TokenAuthenticationProvider implements AuthenticationProvider {

    private final LoginService loginService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = (String) authentication.getCredentials();
        PermUser permUser = loginService.getPermUser(token);
        if (permUser != null) {
            return new UsernamePasswordAuthenticationToken(permUser, null,
                    permUser.getAuthorities().stream()
                            .map(SimpleGrantedAuthority::new)
                            .collect(Collectors.toList())
            );
        }
        throw new CredentialsExpiredException(token);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(TokenAuthentication.class);
    }
}
