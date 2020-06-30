package cn.dhbin.beluga.config.security;

import cn.dhbin.beluga.config.Constant;
import cn.dhbin.beluga.model.enums.ErrorCode;
import cn.dhbin.minion.core.common.response.ApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 处理登录失败
 *
 * @author donghaibin
 * @date 2020/7/1
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class LoginFailureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        ApiResponse<?> response = ApiResponse.fail(ErrorCode.LOGIN_FAILED);
        String responseStr = objectMapper.writeValueAsString(response);
        httpServletResponse.addHeader(HttpHeaders.CONTENT_TYPE, Constant.HTTP_HEADER_JSON_UTF8);
        PrintWriter writer = httpServletResponse.getWriter();
        writer.print(responseStr);
        writer.close();
    }
}
