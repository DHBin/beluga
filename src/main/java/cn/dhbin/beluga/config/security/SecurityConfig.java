package cn.dhbin.beluga.config.security;

import cn.dhbin.beluga.config.ConfigConstant;
import cn.dhbin.beluga.upms.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.HeaderWriterFilter;

/**
 * 鉴权配置
 *
 * @author donghaibin
 * @date 2020/6/30
 */
@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final String[] EXCLUDE_PATH = new String[]{
            // api文档url
            "/doc.html", "/webjars/**", "/service-worker.js", "/swagger-resources/**", "/v2/api-docs",
            // 用户登录url
            ConfigConstant.UMPS_PREFIX + "/user/login",
            // 获取验证码url
            "/code"
    };

    @Autowired
    private LoginService loginService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin().disable()
                .sessionManagement().disable()
                .logout().disable()
                .addFilterAfter(new TokenAuthenticationFilter(loginService), HeaderWriterFilter.class)
                .authorizeRequests()
                .antMatchers(EXCLUDE_PATH).permitAll()
                .anyRequest().authenticated()
                .and().headers().cacheControl().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


}
