package cn.royhsu.blogzuul.service;

import cn.royhsu.common.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Ethan Liu
 * @since 2019/4/24 17:23
 */

@FeignClient(value = "admin-server")
public interface LoginService extends UserService {

}
