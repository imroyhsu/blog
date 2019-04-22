package cn.royhsu.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
public class UserInfo {
    private String username;
    private String password;
    private String salt;
}
