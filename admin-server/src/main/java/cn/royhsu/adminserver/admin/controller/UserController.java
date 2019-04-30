package cn.royhsu.adminserver.admin.controller;


import cn.royhsu.adminserver.admin.entity.User;
import cn.royhsu.adminserver.admin.service.UserService;
import cn.royhsu.core.http.HttpResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/getOne/{id}")
    public User getById(@PathVariable(value = "id") int id ){
        return userService.getById(id);

    }

    @RequestMapping("/getByPage")
    public HttpResult getByPage(){

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("id");
        Page<User> page = new Page<>(1,5);
        IPage<User> iPage = userService.page(page,queryWrapper);
        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getSize());
        return HttpResult.ok(iPage);
    }



}