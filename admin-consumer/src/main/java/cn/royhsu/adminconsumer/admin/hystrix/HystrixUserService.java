package cn.royhsu.adminconsumer.admin.hystrix;

import cn.royhsu.adminconsumer.admin.service.UserService;
import cn.royhsu.common.admin.entity.Page;
import cn.royhsu.common.admin.entity.User;
import cn.royhsu.core.http.HttpResult;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Ethan Liu
 * @since 2019/5/18 21:47
 */
@Component
public class HystrixUserService implements UserService {


    @Override
    @RequestMapping(value = "/user/getByPage",method = RequestMethod.GET)
    public HttpResult<IPage<User>> findPage(Page page) {
        return null;
    }

    @Override
    @RequestMapping(value = "/user/getById/{id}",method = RequestMethod.GET)
    public HttpResult<User> getById(@PathVariable("id") Serializable id) {
        return HttpResult.error("sorry,this service failed");
    }

    @Override
    @RequestMapping(value = "/user/getByName/{name}",method = RequestMethod.GET)
    public HttpResult<User> getByName(@PathVariable("name") String name) {
        return HttpResult.error("sorry,this service failed");
    }

    @Override
    @RequestMapping(value = "/user/getPermissionsByName/{name}",method = RequestMethod.GET)
    public HttpResult<Set<String>> findPermissions(@PathVariable("name") String username) {
        return HttpResult.error("sorry,this service failed");
    }
}
