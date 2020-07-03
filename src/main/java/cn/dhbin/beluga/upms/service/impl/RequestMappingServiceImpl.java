package cn.dhbin.beluga.upms.service.impl;

import cn.dhbin.beluga.upms.config.UpmsConstant;
import cn.dhbin.beluga.upms.model.RequestMappingInfo;
import cn.dhbin.beluga.upms.service.RequestMappingService;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author donghaibin
 * @date 2020/6/30
 */
@Service
@RequiredArgsConstructor
public class RequestMappingServiceImpl implements RequestMappingService {

    /**
     * 请求映射信息
     * <p>
     * {@link org.springframework.web.bind.annotation.RequestMapping}
     * {@link org.springframework.stereotype.Controller}
     * {@link org.springframework.web.bind.annotation.RestController}
     */
    private final RequestMappingHandlerMapping mapping;

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * 排除url
     */
    private final List<String> EXCLUDE_URL = Arrays.asList(
            "/error",
            "/swagger-resources/**",
            "/v2/api-docs-ext"
    );

    @Override
    public List<RequestMappingInfo> all() {
        Map<org.springframework.web.servlet.mvc.method.RequestMappingInfo, HandlerMethod> handlerMethods = mapping.getHandlerMethods();
        return handlerMethods.entrySet()
                .stream()
                .filter(this::exclude)
                .map(this::convertRequestMappingInfo)
                .distinct()
                .collect(Collectors.toList());
    }


    private boolean exclude(Map.Entry<org.springframework.web.servlet.mvc.method.RequestMappingInfo, HandlerMethod> entry) {
        org.springframework.web.servlet.mvc.method.RequestMappingInfo mappingInfo = entry.getKey();
        PatternsRequestCondition patternsCondition = mappingInfo.getPatternsCondition();
        for (String pattern : patternsCondition.getPatterns()) {
            for (String excludePattern : EXCLUDE_URL) {
                if (antPathMatcher.match(excludePattern, pattern)) {
                    return false;
                }
            }
        }
        return true;
    }

    private RequestMappingInfo convertRequestMappingInfo(Map.Entry<org.springframework.web.servlet.mvc.method.RequestMappingInfo, HandlerMethod> entry) {
        RequestMappingInfo info = new RequestMappingInfo();
        Class<?> beanType = entry.getValue().getBeanType();
        Api api = beanType.getDeclaredAnnotation(Api.class);
        if (api != null && api.tags().length > 0) {
            // 默认取 tags 的第一个指
            info.setOwn(api.tags()[0]);
        } else {
            info.setOwn(UpmsConstant.DEFAULT_OWN);
        }

        // 设置路径
        PatternsRequestCondition patternsCondition = entry.getKey().getPatternsCondition();
        info.setPath(patternsCondition.getPatterns().toArray(new String[]{}));

        // 设置请求方法
        RequestMethodsRequestCondition methodsCondition = entry.getKey().getMethodsCondition();
        info.setMethod(methodsCondition.getMethods().stream().map(Enum::toString).toArray(String[]::new));

        // 设置名称、描述、权限信息等
        ApiOperation apiOperation = entry.getValue().getMethodAnnotation(ApiOperation.class);
        if (apiOperation != null) {
            info.setName(apiOperation.value());
            info.setDescription(apiOperation.notes());
            List<String> authorizations = Arrays.stream(apiOperation.authorizations())
                    .map(Authorization::value)
                    .collect(Collectors.toList());
            info.setAuthorizations(String.join(StrUtil.COMMA, authorizations));
        }

        // md5(own + method[] + path[])
        String methods = String.join(StrUtil.COMMA, info.getMethod());
        String paths = String.join(StrUtil.COMMA, info.getPath());
        String id = SecureUtil.md5(info.getOwn() + methods + paths);
        info.setId(id);
        return info;
    }

}
