package cn.royhsu.blogsso.admin.config;

import cn.royhsu.blogsso.admin.entity.User;
import cn.royhsu.blogsso.admin.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;


public class MyRealm extends AuthorizingRealm {

    //调用服务
    @Resource
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("开始权限配置");
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        return null;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("开始身份认证");

        String username = (String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());
        User user = userService.getOne(new QueryWrapper<User>()
                .eq(User.Fields.username, username));//调用mybatis-plus的条件查询
        System.out.println("User" + user);//测试
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(password)) {
            throw new IncorrectCredentialsException("密码错误");
        }
        //若成功，则返回一个封装了信息的AuthenticationInfo
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                username,
                password,
                ByteSource.Util.bytes(user.getSalt()),
                this.getName()
        );
        return authenticationInfo;

    }
}
