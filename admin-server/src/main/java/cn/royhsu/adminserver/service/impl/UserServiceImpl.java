package cn.royhsu.adminserver.service.impl;

import cn.royhsu.adminserver.mapper.UserMapper;
import cn.royhsu.adminserver.service.UserService;
import cn.royhsu.common.entity.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}