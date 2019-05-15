package cn.royhsu.adminserver.admin.config;

import cn.royhsu.adminserver.admin.entity.User;
import cn.royhsu.adminserver.admin.entity.UserToken;
import cn.royhsu.adminserver.admin.service.UserService;
import cn.royhsu.adminserver.admin.service.UserTokenService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;

/**
 * 认证Realm实现
 *
 * @author Ethan Liu
 * @since 2019/5/3 23:22
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Resource
    private UserTokenService userTokenService;
    @Resource
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(接口保护，验证接口调用权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("开始权限配置");
        User user = (User) principals.getPrimaryPrincipal();
        // 用户权限列表，根据用户拥有的权限标识与如 @permission标注的接口对比，决定是否可以调用接口
        Set<String> permSet = userService.findPermissions(user.getUsername());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permSet);
        return authorizationInfo;
    }


    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("开始身份认证");
        String aToken = (String) token.getPrincipal();
        // 根据accessToken，查询用户token信息
        UserToken userToken = userTokenService.getOne(new QueryWrapper<UserToken>().
                eq(UserToken.Fields.token, aToken));
        if (userToken == null || userToken.getExpireTime().getTime() < System.currentTimeMillis()) {
            // token已经失效
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        // 查询用户信息，并验证是否被锁定
        User user = userService.getById(userToken.getUserId());
        if (user.getStatus() == 0) {
            throw new LockedAccountException("账号已被锁定，请联系管理员");
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, aToken, getName());
        return authenticationInfo;
    }
}
