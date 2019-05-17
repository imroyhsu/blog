package cn.royhsu.adminconsumer.admin.controller;


import cn.royhsu.adminconsumer.admin.service.MenuService;
import cn.royhsu.common.admin.entity.Menu;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    private MenuService menuService;


    @RequestMapping(value = "/getByUserId/{id}", method = RequestMethod.GET)
    public List<Menu> getByUserId(@PathVariable(value = "id") Serializable userId) {
        return menuService.findByUserId(userId);
    }

    @RequestMapping(value = "/getByUsername/{username}", method = RequestMethod.GET)
    public List<Menu> getByUsername(@PathVariable(value = "username") String username) {
        return menuService.findByUsername(username);
    }

    @RequestMapping(value = "/getByRoleId/{id}", method = RequestMethod.GET)
    public List<Menu> getByRoleId(@PathVariable(value = "id") Serializable roleId) {
        return menuService.findByRoleId(roleId);
    }
}
