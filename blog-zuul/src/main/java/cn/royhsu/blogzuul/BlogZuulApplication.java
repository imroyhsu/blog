package cn.royhsu.blogzuul;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("cn.royhsu.adminserver.admin.mapper")
public class BlogZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogZuulApplication.class, args);
    }

}
