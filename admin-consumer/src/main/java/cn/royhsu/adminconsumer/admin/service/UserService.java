package cn.royhsu.adminconsumer.admin.service;

import cn.royhsu.adminconsumer.admin.hystrix.HystrixUserService;
import cn.royhsu.common.admin.entity.Page;
import cn.royhsu.common.admin.entity.User;
import cn.royhsu.core.http.HttpResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
@FeignClient(value = "admin-server",fallback = HystrixUserService.class)
public interface UserService  {

    @RequestMapping(value = "/user/getByPage",method = RequestMethod.GET)
    HttpResult<IPage<User>> findPage(@RequestBody Page page);

    @RequestMapping(value = "/user/getById/{id}",method = RequestMethod.GET)
    HttpResult<User> getById(@PathVariable("id") Serializable id);

    @RequestMapping(value = "/user/getByName/{name}",method = RequestMethod.GET)
    HttpResult<User> getByName(@PathVariable("name") String name);

    @RequestMapping(value = "/user/getPermissionsByName/{name}",method = RequestMethod.GET)
    HttpResult<Set<String>> findPermissions(@PathVariable("name") String username);


}
