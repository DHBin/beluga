package cn.dhbin.beluga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author donghaibin
 */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy = true)
public class BelugaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BelugaApplication.class, args);
    }

}
