package cn.royhsu.blogzuul.controller;

import cn.royhsu.blogzuul.service.ZuulLoginService;
import cn.royhsu.core.http.HttpResult;
import cn.royhsu.core.vo.LoginBean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ethan Liu
 * @since 2019/5/8 23:32
 */
@RestController
public class ZuulLoginController {
    @Resource
    private ZuulLoginService zuulLoginService;
    @PostMapping("/login")
    public HttpResult loginVerify(@RequestBody LoginBean loginBean){
        return zuulLoginService.loginVerify(loginBean);
    }
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response) throws SecurityException, IOException{
        System.out.println("进入zuul的controller");
        zuulLoginService.captcha(response);
    }
}
