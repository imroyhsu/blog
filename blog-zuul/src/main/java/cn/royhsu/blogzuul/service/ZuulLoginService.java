package cn.royhsu.blogzuul.service;

import cn.royhsu.core.http.HttpResult;
import cn.royhsu.core.vo.LoginBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@FeignClient(name = "admin-server")
public interface ZuulLoginService {
    @RequestMapping("/login")
    HttpResult loginVerify(@RequestBody LoginBean loginBean);
    @RequestMapping("captcha.jpg")
    void captcha(HttpServletResponse response) throws SecurityException, IOException;
}
