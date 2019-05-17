package cn.royhsu.blogsso.admin.service.impl;

import cn.royhsu.blogsso.admin.mapper.UserMapper;
import cn.royhsu.blogsso.admin.service.UserService;
import cn.royhsu.common.admin.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getByName(String name) {
        return userMapper.findByName(name);
    }
}
