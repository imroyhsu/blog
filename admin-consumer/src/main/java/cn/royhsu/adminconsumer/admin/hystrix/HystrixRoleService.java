package cn.royhsu.adminconsumer.admin.hystrix;

import cn.royhsu.adminconsumer.admin.service.RoleService;
import cn.royhsu.common.admin.entity.Role;
import cn.royhsu.core.http.HttpResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ethan Liu
 * @since 2019/5/18 21:34
 */
@Component
public class HystrixRoleService implements RoleService {


    @Override
    @RequestMapping(value = "/role/getByUserId/{id}",method = RequestMethod.GET)
    public HttpResult<List<Role>> findByUserId(@PathVariable("id") Serializable userId) {
        return HttpResult.error("sorry,this service failed");
    }
}
