package cn.royhsu.adminconsumer.admin.service;

import cn.royhsu.adminconsumer.admin.hystrix.HystrixMenuService;
import cn.royhsu.common.admin.entity.Menu;
import cn.royhsu.core.http.HttpResult;
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
@FeignClient(value = "admin-server",fallback = HystrixMenuService.class)
public interface MenuService  {
    @RequestMapping(value = "/menu/getByRoleId/{id}", method = RequestMethod.GET)
    HttpResult<List<Menu>> findByRoleId(@PathVariable(value = "id") Serializable roleId);

    @RequestMapping(value = "/menu/getByUserId/{id}",method = RequestMethod.GET)
    HttpResult<List<Menu>> findByUserId(@PathVariable(value = "id") Serializable userId);

    @RequestMapping(value = "/menu/getByUsername/{username}",method = RequestMethod.GET)
    HttpResult<List<Menu>> findByUsername(@PathVariable(value = "username") String username);
}
