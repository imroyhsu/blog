package cn.royhsu.adminconsumer.admin.hystrix;

import cn.royhsu.adminconsumer.admin.service.UserRoleService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ethan Liu
 * @since 2019/5/18 21:47
 */
@Component
@RequestMapping("/userRole")
public class HystrixUserRoleService implements UserRoleService {

}
