package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.entity.UserRole;
import cn.royhsu.adminserver.admin.mapper.UserRoleMapper;
import cn.royhsu.adminserver.admin.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
