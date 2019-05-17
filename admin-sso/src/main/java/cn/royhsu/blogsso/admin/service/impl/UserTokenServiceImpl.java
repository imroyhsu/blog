package cn.royhsu.blogsso.admin.service.impl;

import cn.royhsu.blogsso.admin.mapper.UserTokenMapper;
import cn.royhsu.blogsso.admin.service.UserTokenService;
import cn.royhsu.blogsso.admin.utils.TokenGenerator;
import cn.royhsu.common.admin.entity.UserToken;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户Token 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-05-03
 */
@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken> implements UserTokenService {

    //一天后过期

    private static Logger logger = LoggerFactory.getLogger(UserTokenServiceImpl.class);
    private final static int EXPIRE = 3600 * 24;

    @Resource
    private RedisService redisService;

    @Override
    public UserToken findByKey(Serializable key) {
        return (UserToken)redisService.getObj(key.toString());
    }


    @Override
    public UserToken createToken(long userId, Serializable key) {

        String token = TokenGenerator.generateToken();

        Date now = new Date();

        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        UserToken userToken = findByKey(key);

        if (userToken != null) {
            userToken.setExpireTime(expireTime);
            userToken.setLastUpdateTime(now);
            userToken.setToken(token);
            redisService.setObj(key.toString(),userToken);
        } else {
            userToken = new UserToken();
            userToken.setExpireTime(expireTime);
            userToken.setLastUpdateTime(now);
            userToken.setToken(token);
            userToken.setUserId(userId);
            userToken.setCreateTime(now);
            redisService.setObj(key.toString(),userToken);
        }
        return userToken;
    }
}