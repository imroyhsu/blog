package cn.royhsu.adminconsumer.admin.hystrix;

import cn.royhsu.adminconsumer.admin.service.DictService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Ethan Liu
 * @since 2019/5/18 21:05
 */
@Component
@RequestMapping("/dict")
public class HystrixDictService implements DictService {
}
