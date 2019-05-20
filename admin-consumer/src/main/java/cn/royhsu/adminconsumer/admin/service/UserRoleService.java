package cn.royhsu.adminconsumer.admin.service;

import cn.royhsu.adminconsumer.admin.hystrix.HystrixUserRoleService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 用户与角色对应关系 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@FeignClient(value = "admin-server",fallback = HystrixUserRoleService.class)
public interface UserRoleService  {

}
