package cn.royhsu.blogzuul.controller;

import cn.royhsu.blogzuul.service.ZuulLoginService;
import cn.royhsu.core.http.HttpResult;
import cn.royhsu.core.vo.LoginBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Ethan Liu
 * @since 2019/5/8 23:32
 */
@RestController
public class ZuulLoginController {
    @Resource
    private ZuulLoginService zuulLoginService;
    @RequestMapping("zuul/login")
    public HttpResult loginVerify(@RequestBody LoginBean loginBean){
        return zuulLoginService.loginVerify(loginBean);
    }
}
