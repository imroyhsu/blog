package cn.royhsu.adminserver.admin.service.impl;


import cn.royhsu.adminserver.admin.mapper.MenuMapper;
import cn.royhsu.adminserver.admin.mapper.UserMapper;
import cn.royhsu.adminserver.admin.service.UserService;
import cn.royhsu.common.admin.entity.Menu;
import cn.royhsu.common.admin.entity.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Resource
    private MenuMapper menuMapper;

    @Override
    public IPage<User> findPage(IPage<User> page, Wrapper<User> queryWrapper) {
        return userMapper.findPage(page, queryWrapper);
    }

    @Override
    public User getById(Serializable id) {
        return userMapper.findById(id);
    }

    @Override
    public User getByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public Set<String> findPermissionsByName(String username) {
        Set<String> perms = new HashSet<>();
        List<Menu> menus = menuMapper.findByUsername(username);
        for (Menu menu : menus) {
            if (menu.getPerms() != null && !"".equals(menu.getPerms())) {
                perms.add(menu.getPerms());
            }
        }
        return perms;
    }
}
