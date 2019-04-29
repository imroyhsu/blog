package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.entity.Role;
import cn.royhsu.adminserver.admin.mapper.RoleMapper;
import cn.royhsu.adminserver.admin.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

}
