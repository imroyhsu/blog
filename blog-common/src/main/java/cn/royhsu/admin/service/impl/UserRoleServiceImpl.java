package cn.royhsu.admin.service.impl;

import cn.royhsu.admin.entity.UserRole;
import cn.royhsu.admin.mapper.UserRoleMapper;
import cn.royhsu.admin.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应表 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-30
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
