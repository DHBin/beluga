package cn.dhbin.beluga.upms.controller;

import cn.dhbin.beluga.upms.service.CaptchaService;
import com.wf.captcha.ArithmeticCaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author donghaibin
 * @date 2020/7/1
 */
@Controller
@RequestMapping("/code")
@RequiredArgsConstructor
@Api(tags = "验证码")
public class CaptchaController {

    private final CaptchaService captchaService;

    @GetMapping
    @ApiOperation(value = "获取验证码", produces = MediaType.IMAGE_PNG_VALUE)
    public void code(String rand, HttpServletResponse httpServletResponse) throws IOException {
        ArithmeticCaptcha captcha = captchaService.createCaptcha(rand);
        httpServletResponse.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.IMAGE_PNG_VALUE);
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();
        captcha.out(outputStream);
    }

}
