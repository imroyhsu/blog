package cn.royhsu.admin.service.impl;

import cn.royhsu.admin.entity.User;
import cn.royhsu.admin.mapper.UserMapper;
import cn.royhsu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
