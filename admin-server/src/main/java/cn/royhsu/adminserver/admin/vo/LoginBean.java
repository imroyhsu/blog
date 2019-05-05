package cn.royhsu.adminserver.admin.vo;

import lombok.Data;

/**
 * @author Ethan Liu
 * @since 2019/5/5 10:54
 */
@Data
public class LoginBean {
    private String account;
    private String password;
    private String captcha;
}
