package cn.royhsu.adminserver.admin.config;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 自定义token对象
 *
 * @author Ethan Liu
 * @since 2019/5/3 23:16
 */

public class OAuth2Token implements AuthenticationToken {
    private static final long serialVersionUID = 1L;

    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }


    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
