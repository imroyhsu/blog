package cn.royhsu.adminserver.admin.service;

import cn.royhsu.adminserver.admin.entity.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
public interface UserService extends IService<User> {
    IPage<User> findPage(IPage<User> page, Wrapper<User> queryWrapper);

    User getById(Serializable id);


}
