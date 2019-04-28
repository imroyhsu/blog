package cn.blog.adminserver.controller;


import cn.blog.adminserver.service.UserService;
import cn.royhsu.common.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.web.bind.annotation.*;

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
public class UserController {
    @Resource
    public UserService userService;

    @RequestMapping(value = "/register")
    public String register(@RequestBody User user){
        System.out.println("addUser");
        System.out.println(user.toString());
        user.setPassword(shiroMd5Util)


    }




}
