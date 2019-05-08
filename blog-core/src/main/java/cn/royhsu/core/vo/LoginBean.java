package cn.royhsu.core.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author Ethan Liu
 * @since 2019/5/5 10:54
 */
@Data
@Component
public class LoginBean {
    private String account;
    private String password;
    private String captcha;
}
