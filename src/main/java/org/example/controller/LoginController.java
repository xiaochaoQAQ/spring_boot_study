package org.example.controller;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.common.RespBean;
import org.example.model.Captcha;
import org.example.model.User;
import org.example.pojo.LoginInfo;
import org.example.pojo.LoginResult;
import org.example.service.ICaptchaService;
import org.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private IUserService userService;

    @Autowired
    private ICaptchaService captchaService;

    //获取图形验证码
    @PostMapping("/login")
    public RespBean login(@RequestBody LoginInfo loginInfo, HttpSession session) throws Exception {
        //用户名密码验证
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.eq("username",loginInfo.getUsername());
        userQueryWrapper.eq("password",loginInfo.getPassword());
        List<User> userList = userService.list(userQueryWrapper);
        User user = null;
        if (userList != null && userList.size() !=0){
             user =  userList.get(0);
        }else{
            return RespBean.error("用户名或密码错误");
        }
        //验证码密码验证
        QueryWrapper<Captcha> captchaQueryWrapper = new QueryWrapper<Captcha>();
        captchaQueryWrapper.eq("session_id",session.getId());
        captchaQueryWrapper.eq("captcha",loginInfo.getCode());
        List<Captcha> captchaList = captchaService.list(captchaQueryWrapper);
        if (captchaList != null && captchaList.size() !=0){
            Captcha captcha =  captchaList.get(0);
        }else{
            return RespBean.error("验证码错误");
        }
        LoginResult result = new LoginResult();
        result.setUser(user);
        result.setTokenHead("bearer");
        result.setToken(UUID.randomUUID().toString());
        result.setUser(user);
        return RespBean.success("登录成功",result);
    }
}
