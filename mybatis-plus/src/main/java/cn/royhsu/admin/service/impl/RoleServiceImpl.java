package cn.royhsu.admin.service.impl;

import cn.royhsu.admin.entity.Role;
import cn.royhsu.admin.mapper.RoleMapper;
import cn.royhsu.admin.service.RoleService;
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
