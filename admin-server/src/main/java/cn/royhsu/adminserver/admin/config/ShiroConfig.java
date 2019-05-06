package cn.royhsu.adminserver.admin.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
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
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
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
        filterChainMap.put("/","anon");
        filterChainMap.put("/sys/login","anon");
        // swagger
        filterChainMap.put("/swagger-ui.html", "anon");
        filterChainMap.put("/swagger-resources", "anon");
        filterChainMap.put("/v2/api-docs", "anon");
        filterChainMap.put("/webjars/springfox-swagger-ui/**", "anon");
        // 验证码
        filterChainMap.put("/captcha.jpg**", "anon");
        // 服务监控
        filterChainMap.put("/actuator/**", "anon");
        filterChainMap.put("/logout","logout");
        //其他都交给OAuth2Filter处理
        filterChainMap.put("/**","oauth2");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        shiroFilterFactoryBean.setSuccessUrl("/index");
//        shiroFilterFactoryBean.setUnauthorizedUrl("/login");
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        System.out.println("开始创建securityManager");//测试用
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm());
        /**
         * 记住我功能入口
         * securityManager.setRememberMeManager();
         */
        return securityManager;
    }

    @Bean
    public OAuth2Realm myRealm(){
        System.out.println("开始创建realm");//测试用
        return new OAuth2Realm();
    }

    //添加AOP支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

}
