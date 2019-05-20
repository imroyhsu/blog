package cn.royhsu.adminconsumer.admin.service;

import cn.royhsu.adminconsumer.admin.hystrix.HystrixLogService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@FeignClient(value = "admin-server",fallback = HystrixLogService.class)
public interface LogService  {

}
