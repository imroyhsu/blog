package cn.royhsu.blogsso.admin.service;

import cn.royhsu.blogsso.admin.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
public interface UserService extends IService<User> {
    User getByName(String id);

}
