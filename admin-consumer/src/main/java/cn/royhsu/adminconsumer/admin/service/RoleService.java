package cn.royhsu.adminconsumer.admin.service;

import cn.royhsu.adminconsumer.admin.entity.Role;
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
@FeignClient("admin-server")
public interface RoleService {
    @RequestMapping(value = "/role/getByUserId/{id}",method = RequestMethod.GET)
    List<Role> findByUserId(@PathVariable("id") Serializable userId);
}
