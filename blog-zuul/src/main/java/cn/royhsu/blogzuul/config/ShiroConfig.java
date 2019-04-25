package cn.royhsu.blogzuul.config;

import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * shiro的配置类 通过configuration和bean注解配置
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //过滤链，/**放最后
        Map<String, String> filterChainMap = new LinkedHashMap<>();
        filterChainMap.put("/static/**", "anon");
        filterChainMap.put("/logout","logout");
        filterChainMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/login");
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        System.out.println("开始创建securityManager");//测试用
        DefaultSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(myRealm());
        /**
         * 记住我功能入口
         * securityManager.setRememberMeManager();
         */
        return securityManager;
    }

    @Bean
    public MyRealm myRealm(){
        System.out.println("开始创建realm");//测试用
        return new MyRealm();
    }

    //添加AOP支持
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
        return authorizationAttributeSourceAdvisor;
    }

    //添加异常处理
    @Bean(name = "SimpleMappingExceptionResolver")
    public SimpleMappingExceptionResolver createExceptionResolver(){
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
        Properties properties = new Properties();
        properties.setProperty("DatabaseException", "databaseError");//数据库异常
        properties.setProperty("UnauthorizedException", "login");//没有权限
        r.setExceptionMappings(properties);
        r.setDefaultErrorView("error");
        r.setExceptionAttribute("ex");
        return r;
    }
}
