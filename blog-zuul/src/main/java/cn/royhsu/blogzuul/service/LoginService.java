package cn.royhsu.blogzuul.service;


import cn.royhsu.blogzuul.config.FeignConfiguration;
import cn.royhsu.common.entity.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Ethan Liu
 * @since 2019/4/24 17:23
 */

@FeignClient(value = "admin-server",configuration = FeignConfiguration.class)
public interface LoginService extends IService<User> {
    @Override
    @RequestLine(value = "GET /login")
    User getOne(@Param("wrapper") Wrapper<User> queryWrapper, boolean throwEx);
}
