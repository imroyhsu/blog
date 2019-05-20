package cn.royhsu.adminserver.admin.service;

import cn.royhsu.common.admin.entity.Menu;
import cn.royhsu.core.http.HttpResult;
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
    HttpResult<List<Menu>> findByRoleId(Serializable roleId);

    HttpResult<List<Menu>> findByUserId(Serializable userId);

    HttpResult<List<Menu>> findByUsername(String username);
}
