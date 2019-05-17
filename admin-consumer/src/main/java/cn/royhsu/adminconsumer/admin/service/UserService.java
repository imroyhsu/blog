package cn.royhsu.adminconsumer.admin.service;

import cn.royhsu.common.admin.entity.Page;
import cn.royhsu.common.admin.entity.User;
import cn.royhsu.core.http.HttpResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@FeignClient("admin-server")
public interface UserService  {

    @RequestMapping("/user/getByPage")
    HttpResult findPage(@RequestBody Page page);

    @RequestMapping(value = "/user/getById/{id}",method = RequestMethod.GET)
    User getById(@PathVariable("id") Serializable id);

    @RequestMapping(value = "/user/getByName/{name}",method = RequestMethod.GET)
    User getByName(@PathVariable("name") String name);

    @RequestMapping(value = "/user/getPermissionsByName/{name}",method = RequestMethod.GET)
    Set<String> findPermissions(@PathVariable("name") String username);

    @RequestMapping(value = "/user/hello",method = RequestMethod.GET)
    String hello();


}
