package cn.royhsu.adminconsumer.admin.controller;


import cn.royhsu.adminconsumer.admin.service.UserService;
import cn.royhsu.adminconsumer.admin.entity.User;
import cn.royhsu.core.http.HttpResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable(value = "id") int id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public User getByName(@PathVariable(value = "name") String name) {
        return userService.getByName(name);
    }


    @RequestMapping(value = "/getByPage", method = RequestMethod.POST)
    public HttpResult getByPage() {
        return userService.findPage(new cn.royhsu.adminconsumer.admin.entity.Page(
                new Page<>(1, 5), new QueryWrapper<User>().orderByAsc("id")
        ));
    }

}
