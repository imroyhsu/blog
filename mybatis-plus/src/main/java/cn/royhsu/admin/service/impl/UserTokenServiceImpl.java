package cn.royhsu.admin.service.impl;

import cn.royhsu.admin.entity.UserToken;
import cn.royhsu.admin.mapper.UserTokenMapper;
import cn.royhsu.admin.service.UserTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户Token 服务实现类
 * </p>
 *
 * @author Ethan Liu
 * @since 2019-04-28
 */
@Service
public class UserTokenServiceImpl extends ServiceImpl<UserTokenMapper, UserToken> implements UserTokenService {

}
