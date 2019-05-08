package cn.royhsu.adminserver.admin.utils;

import org.apache.shiro.crypto.hash.Sha256Hash;

import java.util.UUID;

/**
 * 密码工具类
 * @author Ethan Liu
 * @since 2019/5/5 14:56
 */
public class PasswordUtils {
    /**
     * 匹配密码
     * @param password
     * @param salt
     * @param encryptedPassword
     * @return
     */
    public static boolean match(String password, String salt, String encryptedPassword){
        return (password != null && encrypt(password,salt).equals(encryptedPassword));
    }

    /**
     * 明文密码加密
     * @param password
     * @param salt
     * @return
     */
    public static String encrypt(String password, String salt){
        return new Sha256Hash(password,salt).toHex();
    }

    /**
     * 获取加密盐
     * @return
     */
    public static String getSalt(){
        return UUID.randomUUID().toString().replaceAll("-","").substring(0,20);
    }


}
