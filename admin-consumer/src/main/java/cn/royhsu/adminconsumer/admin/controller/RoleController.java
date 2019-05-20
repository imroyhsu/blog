package cn.royhsu.adminconsumer.admin.controller;


import cn.royhsu.adminconsumer.admin.service.RoleService;
import cn.royhsu.common.admin.entity.Role;
import cn.royhsu.core.http.HttpResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    private RoleService roleService;

    @RequestMapping(value = "/getByUserId/{id}",method = RequestMethod.GET)
    public HttpResult<List<Role>> findByUserId(@PathVariable("id") Serializable userId){
        return roleService.findByUserId(userId);
    }


}
