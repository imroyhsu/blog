package cn.royhsu.adminconsumer.admin.controller;

import cn.royhsu.adminconsumer.admin.service.UserService;
import cn.royhsu.common.admin.entity.User;
import cn.royhsu.core.http.HttpResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Set;

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
    public HttpResult<User> getById(@PathVariable(value = "id") int id) {
        return userService.getById(id);
    }


    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public HttpResult<User> getByName(@PathVariable(value = "name") String name) {
        return userService.getByName(name);
    }


    @RequestMapping(value = "/getPermissionsByName/{name}",method = RequestMethod.GET)
    public HttpResult<Set<String>> getPermissions(@PathVariable("name") String username){
        return userService.findPermissions(username);
    }


    @RequestMapping(value = "/getByPage", method = RequestMethod.POST)
    public IPage<User> getByPage() {
        return  userService.findPage(new cn.royhsu.common.admin.entity.Page(
                new Page<>(1, 5), new QueryWrapper<User>().orderByAsc("id")
        )).getData();
    }

}
