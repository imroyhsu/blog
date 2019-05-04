package cn.royhsu.adminserver.admin.service;

import cn.royhsu.adminserver.admin.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
public interface MenuService extends IService<Menu> {
    List<Menu> findByRoleId(Serializable roleId);
    List<Menu> findByUserId(Serializable userId);
    List<Menu> findByUsername(String username);
}
