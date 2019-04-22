package cn.royhsu.blogzuul.config;

import cn.royhsu.common.pojo.UserInfo;
import cn.royhsu.common.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;


/**
 * 由于使用了feign，这里不参与数据库读取，直接调用common包中暴露的服务
 */
public class MyRealm extends AuthorizingRealm{

    @Resource
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("开始权限配置");
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        UserInfo userInfo = (UserInfo)principalCollection.getPrimaryPrincipal();


        return null;
    }

    //
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("开始身份认证");
        String username = (String) token.getPrincipal();
        String password = (String) token.getCredentials();
        UserInfo userInfo = userService.findByUsername(username);
        System.out.println("Userinfo" + userInfo);
        if (userInfo == null){
            return null;
        }
        if(!userInfo.getPassword().equals(password)){
            throw new IncorrectCredentialsException("密码错误");
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username,
                password,
                ByteSource.Util.bytes(userInfo.getSalt()),
                this.getName()
        );
        return authenticationInfo;

    }
}
