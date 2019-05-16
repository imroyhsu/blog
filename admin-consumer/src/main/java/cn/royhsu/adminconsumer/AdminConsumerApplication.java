package cn.royhsu.adminconsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class AdminConsumerApplication {
    private static final Logger LOG = LoggerFactory.getLogger(AdminConsumerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AdminConsumerApplication.class, args);
    }
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "roy") String name) {
        LOG.info("------------hihihihihhi");
        LOG.debug("dddddddddddddddddddddd");
        return "hi " + name + " ,i am from port:" + port;
    }

}
