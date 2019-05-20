package cn.royhsu.adminserver.admin.service;

import cn.royhsu.common.admin.entity.Role;
import cn.royhsu.core.http.HttpResult;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
public interface RoleService extends IService<Role> {
    HttpResult<List<Role>> findByUserId(Serializable userId);
}
