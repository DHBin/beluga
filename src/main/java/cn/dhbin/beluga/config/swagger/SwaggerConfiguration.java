package cn.dhbin.beluga.config.swagger;

import cn.dhbin.minion.core.swagger.config.SwaggerProperties;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

/**
 * @author dhb
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket groupDocket(ApiInfo apiInfo, SwaggerProperties swaggerProperties) {
        return (new Docket(DocumentationType.SWAGGER_2))
                .apiInfo(apiInfo).select()
                .apis(RequestHandlerSelectors.basePackage(swaggerProperties.getBasePackage()))
                .paths(PathSelectors.any()).build()
                .securityContexts(Collections.singletonList(
                        SecurityContext.builder()
                                .securityReferences(defaultAuth())
                                .forPaths(PathSelectors.regex("/.*"))
                        .build()
                ))
                .securitySchemes(Collections.singletonList(
                        new ApiKey("BearerToken", "Authorization", "header")
                ));
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("BearerToken", authorizationScopes));
    }

}
