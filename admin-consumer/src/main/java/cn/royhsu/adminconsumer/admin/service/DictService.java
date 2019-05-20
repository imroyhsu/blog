package cn.royhsu.adminconsumer.admin.service;

import cn.royhsu.adminconsumer.admin.hystrix.HystrixDictService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>
 * 字典表 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@FeignClient(value = "admin-server",fallback = HystrixDictService.class)
public interface DictService {

}
