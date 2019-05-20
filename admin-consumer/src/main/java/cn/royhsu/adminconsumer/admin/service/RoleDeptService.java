package cn.royhsu.adminconsumer.admin.service;

import cn.royhsu.adminconsumer.admin.hystrix.HystrixRoleDeptService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 角色与机构对应关系 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@FeignClient(value = "admin-server",fallback = HystrixRoleDeptService.class)
public interface RoleDeptService  {

}
