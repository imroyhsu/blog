package cn.royhsu.common.service;

import cn.royhsu.common.pojo.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "")//DAO层服务是admin-server提供的，此处引入该服务的配置文件里的名称
public interface UserService {
    @RequestMapping(value = "/user/getUserInfoByUsername", method = RequestMethod.GET)
    UserInfo findByUsername(@RequestParam(value = "username") String username);

}
