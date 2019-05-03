package cn.royhsu.adminserver.admin.service.impl;

import cn.royhsu.adminserver.admin.entity.UserToken;
import cn.royhsu.adminserver.admin.mapper.UserTokenMapper;
import cn.royhsu.adminserver.admin.service.UserTokenService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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


}
