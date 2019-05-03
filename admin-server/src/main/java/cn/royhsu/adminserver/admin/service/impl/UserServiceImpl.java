package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.entity.User;
import cn.royhsu.adminserver.admin.mapper.UserMapper;
import cn.royhsu.adminserver.admin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

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
    public IPage<User> findPage(IPage<User> page, Wrapper<User> queryWrapper) {
        return userMapper.findPage(page, queryWrapper);
    }

    @Override
    public User getById(Serializable id) {
        return userMapper.findById(id);
    }


}
