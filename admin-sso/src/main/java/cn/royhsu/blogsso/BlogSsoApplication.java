package cn.royhsu.blogsso;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
@EnableEurekaClient
@EnableRedisHttpSession
@MapperScan("cn.royhsu.blogsso.admin.mapper")
public class BlogSsoApplication {
    private static final Logger LOG = LoggerFactory.getLogger(BlogSsoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BlogSsoApplication.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "roy") String name) {
        LOG.info("------------hi");
        return "hi " + name + " ,i am from port:" + port;
    }
}
