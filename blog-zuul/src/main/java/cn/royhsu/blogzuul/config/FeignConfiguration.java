package cn.royhsu.blogzuul.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ethan Liu
 * @since 2019/4/25 20:19
 */
@Configuration
public class FeignConfiguration {
    /**
     * 将契约改为feign原生的默认契约。这样就可以使用feign自带的注解了。
     * 用feign.Contract.Default替换SpringMvcContract契约
     *
     * @return 默认的feign契约
     */
    @Bean
    public Contract feignContract() {
        //Spring Cloud Netflix默认的SpringMvcController将替换为feign.Contract.Default。
        return new feign.Contract.Default();
    }
}


