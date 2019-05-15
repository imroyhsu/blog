package cn.royhsu.blogsso.admin.config;

import cn.royhsu.blogsso.admin.entity.User;
import cn.royhsu.blogsso.admin.entity.UserToken;
import cn.royhsu.blogsso.admin.service.UserService;
import cn.royhsu.blogsso.admin.service.UserTokenService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
        return null;
    }


    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("开始身份认证");
        String aToken = (String) token.getPrincipal();
        // 根据accessToken，查询用户token信息
        UserToken userToken = userTokenService.findByKey(SecurityUtils.getSubject().getSession().getId().toString());
        if (userToken!=null && userToken.getExpireTime().getTime() >= System.currentTimeMillis()) {
            if(userToken.getToken().equals(aToken) ) {
                // 查询用户信息，并验证是否被锁定
                User user = userService.getById(userToken.getUserId());
                if (user.getStatus() == 0) {
                    throw new LockedAccountException("账号已被锁定，请联系管理员");
                }
                SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, aToken, getName());
                return authenticationInfo;
            }else {
                // token已经失效
                throw new IncorrectCredentialsException("token失效，请重新登录");
            }
        }else {
            // token已经失效
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }

    }
}
