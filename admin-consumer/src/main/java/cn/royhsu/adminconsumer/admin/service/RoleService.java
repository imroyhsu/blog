package cn.royhsu.adminconsumer.admin.service;

import cn.royhsu.adminconsumer.admin.hystrix.HystrixRoleService;
import cn.royhsu.common.admin.entity.Role;
import cn.royhsu.core.http.HttpResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@FeignClient(value = "admin-server",fallback = HystrixRoleService.class)
public interface RoleService {
    @RequestMapping(value = "/role/getByUserId/{id}",method = RequestMethod.GET)
    HttpResult<List<Role>> findByUserId(@PathVariable("id") Serializable userId);
}
