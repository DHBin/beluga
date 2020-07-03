package cn.dhbin.beluga.config;

import cn.dhbin.minion.core.common.enums.ErrorCodeEnum;
import cn.dhbin.minion.core.common.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author donghaibin
 * @date 2020/7/3
 */
@RestControllerAdvice
@Slf4j
public class RestControllerExceptionHandlerConfig {


    @ExceptionHandler(AccessDeniedException.class)
    public ApiResponse<?> handle() {
        return ApiResponse.fail(ErrorCodeEnum.FORBIDDEN);
    }


}
