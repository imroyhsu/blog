package cn.royhsu.adminserver.admin.vo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Ethan Liu
 * @since 2019/5/5 10:54
 */
@Getter
@Setter
@Component
public class LoginBean {
    private String account;
    private String password;
    private String captcha;
}
