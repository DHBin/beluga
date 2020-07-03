package cn.dhbin.beluga.config;

import cn.dhbin.beluga.util.SecurityUtil;
import cn.dhbin.minion.core.common.IUserInfoProvider;
import cn.dhbin.minion.core.mybatis.plugins.PerformanceInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Configuration
@Slf4j
@MapperScan("cn.dhbin.beluga.*.mapper")
public class MybatisConfig {

    @Bean
    public IUserInfoProvider userInfoProvider() {
        return () -> {
            try {
                return SecurityUtil.getUserId();
            } catch (Exception e) {
                log.warn("当前环境没有登录， 默认返回1L");
                return 1L;
            }
        };
    }

    @Bean
    @ConditionalOnProperty(prefix = "minion", name = "dev", havingValue = "true")
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

}
