package cn.dhbin.beluga;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author donghaibin
 */
@SpringBootApplication
@MapperScan("cn.dhbin.beluga.*.mapper")
@EnableCaching
@EnableAspectJAutoProxy(exposeProxy = true)
public class BelugaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BelugaApplication.class, args);
    }

}
