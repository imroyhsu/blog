package cn.royhsu.common.utils;

/**
 * 字符串工具类
 *
 * @author Ethan Liu
 * @since 2019/5/3 23:02
 */
public class StringUtils {

    /**
     * 判空操作
     *
     * @param value
     * @return
     */
    public static boolean isBlank(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }

}
