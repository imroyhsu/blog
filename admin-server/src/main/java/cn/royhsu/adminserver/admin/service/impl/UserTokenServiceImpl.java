package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.entity.UserToken;
import cn.royhsu.adminserver.admin.mapper.UserTokenMapper;
import cn.royhsu.adminserver.admin.service.UserTokenService;
import cn.royhsu.adminserver.admin.utils.TokenGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
    private final static int EXPIRE = 3600 * 24;



    @Override
    public UserToken findByUserId(Serializable userId) {
        return getOne(new QueryWrapper<UserToken>().eq(UserToken.Fields.userId,userId));
    }


    @Override
    public UserToken createToken(long userId) {
        String token = TokenGenerator.generateToken();

        Date now = new Date();

        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        UserToken userToken = findByUserId(userId);
        if(userToken != null){
            userToken.setExpireTime(expireTime);
            userToken.setLastUpdateTime(now);
            userToken.setToken(token);
            updateById(userToken);
        }else {
            userToken = new UserToken();
            userToken.setExpireTime(expireTime);
            userToken.setLastUpdateTime(now);
            userToken.setToken(token);
            userToken.setUserId(userId);
            userToken.setCreateTime(now);
            save(userToken);
        }

        return userToken;


    }
}
