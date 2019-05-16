package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.entity.UserToken;
import cn.royhsu.adminserver.admin.mapper.UserTokenMapper;
import cn.royhsu.adminserver.admin.service.UserTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;

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
    private RedisServiceImpl redisService;

    @Override
    public UserToken findByKey(Serializable key) {
        return (UserToken)redisService.getObj(key.toString());
    }

}