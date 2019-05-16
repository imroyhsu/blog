package cn.royhsu.adminserver.admin.controller;


import cn.royhsu.adminserver.admin.entity.User;
import cn.royhsu.adminserver.admin.service.impl.UserServiceImpl;
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
    private UserServiceImpl userService;

    @RequestMapping("/getById/{id}")
    public User getById(@PathVariable(value = "id") int id) {
        return userService.getById(id);
    }

    @RequestMapping("/getByName/{name}")
    public User getByName(@PathVariable(value = "name") String name) {
        return userService.getByName(name);
    }

    @RequestMapping("/getByPage")
    public HttpResult getByPage() {
        IPage<User> iPage = userService.page(new Page<>(1, 5), new QueryWrapper<User>().orderByAsc("id"));
        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getSize());
        return HttpResult.ok(iPage);
    }


}
