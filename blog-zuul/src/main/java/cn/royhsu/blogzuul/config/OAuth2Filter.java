package cn.royhsu.blogzuul.config;

import cn.royhsu.common.utils.StringUtils;
import cn.royhsu.core.http.HttpResult;
import cn.royhsu.core.http.HttpStatus;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Oauth2过滤器
 * @author Ethan Liu
 * @since 2019/5/3 22:09
 */
public class OAuth2Filter extends AuthenticatingFilter {
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) throws Exception {
        // 获取请求token
        String token = getRequestToken((HttpServletRequest) request);
        if(StringUtils.isBlank(token)){
            return null;
        }
        return new OAuth2Token(token);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }


    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        // 获取请求token，如果token不存在，直接返回401
        String token = getRequestToken((HttpServletRequest) request);
        if(StringUtils.isBlank(token)){
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            HttpResult result = HttpResult.error(HttpStatus.SC_UNAUTHORIZED, "invalid token");
            String json = JSONObject.toJSONString(result);
            httpResponse.getWriter().print(json);
            return false;
        }
        return executeLogin(request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setContentType("application/json; charset=utf-8");
        try {
            // 处理登录失败的异常
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            HttpResult result = HttpResult.error(HttpStatus.SC_UNAUTHORIZED, throwable.getMessage());
            String json = JSONObject.toJSONString(result);
            httpResponse.getWriter().print(json);
        } catch (IOException e1) {
        }
        return false;
    }


    /**
     * 获取请求的token
     */
    private String getRequestToken(HttpServletRequest httpServletRequest){
        String token = httpServletRequest.getHeader("token");
        if(StringUtils.isBlank("token")){
            token = httpServletRequest.getParameter("token");
        }
        return token;
    }
}