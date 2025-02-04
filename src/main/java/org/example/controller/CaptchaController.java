package org.example.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.example.model.Captcha;
import org.example.service.ICaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping
public class CaptchaController {
    private final static String SESSION_KEY = "captcha";    // 验证码session key

    @Autowired
    private ICaptchaService captchaService;



    //获取图形验证码
    @GetMapping("/captcha")
    public void generateCaptcha(HttpServletResponse response, HttpSession session) throws Exception {
        // 创建一个线型验证码实例
        LineCaptcha captcha = CaptchaUtil.createLineCaptcha(95, 40, 4,40); // 宽度、高度、字符和干扰线数量可自定义

        // 设置验证码内容和输出到http响应
        String code = captcha.getCode(); // 获取验证码文本内容
        captcha.write(response.getOutputStream()); // 输出图片到浏览器
        Captcha captchaInfo = new Captcha();
        captchaInfo.setSessionId(session.getId());
        captchaInfo.setCaptcha(code);
        captchaService.save(captchaInfo);
        //将验证码内容存入响应头中
        response.setHeader(SESSION_KEY, code);//这里的SESSION_KEY是我在前面自定义的一个常量字符串

    }
}
