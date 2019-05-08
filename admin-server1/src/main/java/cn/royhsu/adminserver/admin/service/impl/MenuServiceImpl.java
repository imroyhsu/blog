package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.entity.Menu;
import cn.royhsu.adminserver.admin.mapper.MenuMapper;
import cn.royhsu.adminserver.admin.service.MenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Resource
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findByRoleId(Serializable roleId) {
        return menuMapper.findByRoleId(roleId);
    }

    @Override
    public List<Menu> findByUserId(Serializable userId) {
        return menuMapper.findByUserId(userId);
    }

    @Override
    public List<Menu> findByUsername(String username) {
        return menuMapper.findByUsername(username);
    }
}
