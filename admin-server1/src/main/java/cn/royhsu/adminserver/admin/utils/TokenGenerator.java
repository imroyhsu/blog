package cn.royhsu.adminserver.admin.utils;

import cn.royhsu.core.exception.BlogException;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * @author Ethan Liu
 * @since 2019/5/5 15:34
 */
public class TokenGenerator {

    private static final char[] hexCode = "0123456789abcdef".toCharArray();

    public static String generateToken() {
        return generateValue(UUID.randomUUID().toString());
    }

    private static String generateValue(String param) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(param.getBytes());
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new BlogException("生成Token失败", e);
        }
    }

    private static String toHexString(byte[] data) {
        if(data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length*2);
        for ( byte b : data) {
            r.append(hexCode[(b >> 4) & 0xF]);
            r.append(hexCode[(b & 0xF)]);
        }
        return r.toString();
    }
}