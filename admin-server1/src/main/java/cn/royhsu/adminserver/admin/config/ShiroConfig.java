package cn.royhsu.adminserver.admin.config;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.mgt.RememberMeManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro的配置类 通过configuration和bean注解配置
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //自定义oauth2过滤器，替代默认的过滤器
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("oauth2", new OAuth2Filter());
        shiroFilterFactoryBean.setFilters(filters);
        //过滤链，/**放最后
        Map<String, String> filterChainMap = new LinkedHashMap<>();
        filterChainMap.put("/static/**", "anon");
        // 查看SQL监控（druid）
        filterChainMap.put("/druid/**", "anon");
        //主页和登录界面
        filterChainMap.put("/", "anon");
        filterChainMap.put("/main", "anon");
        // swagger
        filterChainMap.put("/swagger-ui.html", "anon");
        filterChainMap.put("/swagger-resources", "anon");
        filterChainMap.put("/v2/api-docs", "anon");
        filterChainMap.put("/webjars/springfox-swagger-ui/**", "anon");
        // 验证码
        filterChainMap.put("/captcha.jpg**", "anon");
        // 服务监控
        filterChainMap.put("/actuator/**", "anon");
        filterChainMap.put("/logout", "logout");
        //其他都交给OAuth2Filter处理
        filterChainMap.put("/**", "oauth2");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    //“记住我”功能的管理器，这里暂时没用上
    @Bean
    public RememberMeManager rememberMeManager(){
        CookieRememberMeManager rememberMeManager = new CookieRememberMeManager();
        rememberMeManager.setCipherKey(Base64.decode("4AvVhmFLUs0KTA3Kprsdag=="));
        rememberMeManager.setCookie(rememberMeCookie());
        return rememberMeManager;
    }

    //自定义的cookie
    @Bean
    public SimpleCookie rememberMeCookie(){
        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(604800);
        simpleCookie.setHttpOnly(true);
        return simpleCookie;
    }

    //自定义的realm
    @Bean
    public OAuth2Realm myRealm() {
        return new OAuth2Realm();
    }

    /**
     * shiro生命周期处理器
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }


    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(放在了yml)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     */

    //添加AOP支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor() {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }




}
