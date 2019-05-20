package cn.royhsu.adminserver.admin.service;

import cn.royhsu.common.admin.entity.User;
import cn.royhsu.core.http.HttpResult;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;
import java.util.Set;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
public interface UserService extends IService<User> {
    HttpResult<IPage<User>> findPage(IPage<User> page, Wrapper<User> queryWrapper);

    HttpResult<User> findById(Serializable id);

    HttpResult<User> getByName(String name);

    HttpResult<Set<String>> findPermissionsByName(String username);


}
