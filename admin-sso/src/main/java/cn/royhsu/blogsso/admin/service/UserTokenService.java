package cn.royhsu.blogsso.admin.service;

import cn.royhsu.common.admin.entity.UserToken;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.Serializable;

/**
 * <p>
 * 用户Token 服务类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-05-03
 */
public interface UserTokenService extends IService<UserToken> {
    UserToken createToken(long userId,Serializable key);
    UserToken findByKey(Serializable key);
}
