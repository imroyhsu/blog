package cn.royhsuuser.service.impl;

import cn.royhsuuser.entity.User;
import cn.royhsuuser.mapper.UserMapper;
import cn.royhsuuser.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
