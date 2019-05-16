package cn.royhsu.adminconsumer.admin.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 机构管理 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@FeignClient("admin-server")
public interface DeptService  {

}
