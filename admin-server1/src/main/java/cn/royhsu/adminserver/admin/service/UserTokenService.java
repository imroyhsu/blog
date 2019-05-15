package cn.royhsu.adminserver.admin.service;

import cn.royhsu.adminserver.admin.entity.UserToken;
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
    UserToken createToken(long id);

    UserToken findByUserId(Serializable userId);
}
