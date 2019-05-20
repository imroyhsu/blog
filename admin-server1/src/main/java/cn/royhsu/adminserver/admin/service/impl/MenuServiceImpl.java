package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.mapper.MenuMapper;
import cn.royhsu.adminserver.admin.service.MenuService;
import cn.royhsu.common.admin.entity.Menu;
import cn.royhsu.core.http.HttpResult;
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
    public HttpResult<List<Menu>> findByRoleId(Serializable roleId) {
        return HttpResult.ok(menuMapper.findByRoleId(roleId));
    }

    @Override
    public HttpResult<List<Menu>> findByUserId(Serializable userId) {
        return HttpResult.ok(menuMapper.findByUserId(userId));
    }

    @Override
    public HttpResult<List<Menu>> findByUsername(String username) {
        return HttpResult.ok(menuMapper.findByUsername(username));
    }
}
