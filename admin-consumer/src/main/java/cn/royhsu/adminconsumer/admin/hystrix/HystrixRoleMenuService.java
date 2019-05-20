package cn.royhsu.adminconsumer.admin.hystrix;

import cn.royhsu.adminconsumer.admin.service.RoleMenuService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ethan Liu
 * @since 2019/5/18 21:34
 */
@Component
@RequestMapping("/roleMenu")
public class HystrixRoleMenuService implements RoleMenuService {
}
