package cn.royhsu.adminserver.admin.controller;


import cn.royhsu.adminserver.admin.entity.Role;
import cn.royhsu.adminserver.admin.service.impl.RoleServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private RoleServiceImpl roleService;

    @GetMapping("/getByUserId/{id}")
    public List<Role> findByUserId (@PathVariable("id") Serializable userId){
        return roleService.findByUserId(userId);
    }

}
