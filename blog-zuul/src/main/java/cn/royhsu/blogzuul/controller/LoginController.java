package cn.royhsu.blogzuul.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Ethan Liu
 * @since 2019/4/24 21:40
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/loginVerify",method = RequestMethod.POST)
    public String loginVerify(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password,false);
        System.out.println(token.toString());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return "index";
        } catch (IncorrectCredentialsException ice) {
            return "error";
        } catch (UnknownAccountException uae){
            return "error";
        }

    }

    @RequestMapping(value = "/login")
    public String login(){
        return ("login");
    }

}
