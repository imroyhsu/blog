package cn.royhsu.admin.service.impl;

import cn.royhsu.admin.entity.RoleMenu;
import cn.royhsu.admin.mapper.RoleMenuMapper;
import cn.royhsu.admin.service.RoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements RoleMenuService {

}
