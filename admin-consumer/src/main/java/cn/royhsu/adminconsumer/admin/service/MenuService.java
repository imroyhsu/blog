package cn.royhsu.adminconsumer.admin.service;

import cn.royhsu.common.admin.entity.Menu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@FeignClient("admin-server")
public interface MenuService  {
    @RequestMapping(value = "/menu/getByUserId/{id}", method = RequestMethod.GET)
    List<Menu> findByRoleId(@PathVariable(value = "id") Serializable roleId);

    @RequestMapping(value = "/menu/getByRoleId/{id}",method = RequestMethod.GET)
    List<Menu> findByUserId(@PathVariable(value = "id") Serializable userId);

    @RequestMapping(value = "/menu/getByUsername/{username}",method = RequestMethod.GET)
    List<Menu> findByUsername(@PathVariable(value = "username") String username);
}
