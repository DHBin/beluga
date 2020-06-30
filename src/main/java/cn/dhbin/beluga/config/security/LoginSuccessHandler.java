package cn.dhbin.beluga.config.security;

import cn.dhbin.beluga.config.Constant;
import cn.dhbin.minion.core.common.enums.ErrorCodeEnum;
import cn.dhbin.minion.core.common.response.ApiResponse;
import cn.hutool.core.lang.UUID;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理登录成功
 *
 * @author donghaibin
 * @date 2020/7/1
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final CacheManager cacheManager;

    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException {
        log.info(authentication.toString());
        Cache cache = cacheManager.getCache(Constant.AUTH_KEY_NAME);
        String uuid = UUID.fastUUID().toString(true);
        httpServletResponse.addHeader(HttpHeaders.CONTENT_TYPE, Constant.HTTP_HEADER_JSON_UTF8);
        ApiResponse<?> response;
        if (cache != null) {
            cache.put(uuid, authentication);
            response = ApiResponse.ok(uuid);
        } else {
            response = ApiResponse.fail(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
        }
        PrintWriter writer = httpServletResponse.getWriter();
        writer.print(objectMapper.writeValueAsString(response));
        writer.close();
    }

}
