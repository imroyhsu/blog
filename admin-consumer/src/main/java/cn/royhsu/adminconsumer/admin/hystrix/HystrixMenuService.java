package cn.royhsu.adminconsumer.admin.hystrix;

import cn.royhsu.adminconsumer.admin.service.MenuService;
import cn.royhsu.common.admin.entity.Menu;
import cn.royhsu.core.http.HttpResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ethan Liu
 * @since 2019/5/18 21:16
 */
@Component
public class HystrixMenuService implements MenuService {

    @Override
    @RequestMapping(value = "/menu/getByUserId/{id}", method = RequestMethod.GET)
        public HttpResult<List<Menu>> findByRoleId(@PathVariable("id") Serializable roleId) {
        return HttpResult.error("sorry,this service failed");
    }

    @Override
    @RequestMapping(value = "/menu/getByRoleId/{id}",method = RequestMethod.GET)
    public HttpResult<List<Menu>> findByUserId(@PathVariable("id") Serializable userId) {
         return HttpResult.error("sorry,this service failed");
    }

    @Override
    @RequestMapping(value = "/menu/getByUsername/{username}",method = RequestMethod.GET)
    public HttpResult<List<Menu>> findByUsername(@PathVariable("username") String username) {
         return HttpResult.error("sorry,this service failed");
    }
}
