package cn.royhsu.adminserver.admin.controller;


import cn.royhsu.adminserver.admin.service.impl.MenuServiceImpl;
import cn.royhsu.common.admin.entity.Menu;
import cn.royhsu.core.http.HttpResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 菜单管理 前端控制器
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Resource
    private MenuServiceImpl menuService;

    @RequestMapping("/getByUserId/{id}")
    @RequiresPermissions("sys:menu:view")
    public HttpResult<List<Menu>> getByUserId(@PathVariable(value = "id") Serializable userId) {
        return menuService.findByUserId(userId);
    }

    @RequestMapping("/getByUsername/{username}")
    public HttpResult<List<Menu>> getByUsername(@PathVariable(value = "username") String username) {
        return menuService.findByUsername(username);
    }

    @RequestMapping("/getByRoleId/{id}")
    public HttpResult<List<Menu>> getByRoleId(@PathVariable(value = "id") Serializable roleId) {
        return menuService.findByRoleId(roleId);
    }
}
