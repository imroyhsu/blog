package cn.royhsu.adminconsumer.admin.service;

import cn.royhsu.adminconsumer.admin.hystrix.HystrixRoleMenuService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 角色与菜单对应关系 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@FeignClient(value = "admin-server",fallback = HystrixRoleMenuService.class)
public interface RoleMenuService {

}
