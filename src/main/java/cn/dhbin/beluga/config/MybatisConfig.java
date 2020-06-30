package cn.dhbin.beluga.config;

import cn.dhbin.minion.core.common.IUserInfoProvider;
import cn.dhbin.minion.core.mybatis.plugins.PerformanceInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author donghaibin
 * @date 2020/3/16
 */
@Configuration
public class MybatisConfig {

    @Bean
    public IUserInfoProvider userInfoProvider() {
        // todo 提供 userInfoProvider
        return () -> 1L;
    }

    @Bean
    @ConditionalOnProperty(prefix = "minion", name = "dev", havingValue = "true")
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

}
