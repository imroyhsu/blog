package cn.blog.adminserver.controller;


import cn.blog.adminserver.service.UserService;
import cn.royhsu.common.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-24
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @Resource
    public UserService userService;

    @RequestMapping(value = "/login/${username}", method = RequestMethod.GET)
    public String login(@RequestParam(value = "username") String name, @RequestParam(value = "password") String password){
        if (userService.getOne(new QueryWrapper<User>()
                .eq(User.Fields.username,name)
                .eq(User.Fields.password,password))!=null){
            return "index";
        }else return "login";
    }




}
