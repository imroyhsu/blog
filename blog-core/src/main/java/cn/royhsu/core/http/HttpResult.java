package cn.royhsu.core.http;

import lombok.Data;

/**
 * HTTP结果封装
 * @author Ethan Liu
 * @since 2019/4/30 11:09
 */
@Data
public class HttpResult {
    private int code = 200; //默认就是200
    private String msg;
    private Object data;

    public static HttpResult error(int code, String msg){
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(code);
        httpResult.setMsg(msg);
        return httpResult;
    }

    public static HttpResult error(String msg){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,msg);
    }

    public static HttpResult error(){
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR,"未知异常，请联系管理员");
    }

    public static HttpResult ok(String msg) {
        HttpResult r = new HttpResult();
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(Object data) {
        HttpResult r = new HttpResult();
        r.setData(data);
        return r;
    }
    public static HttpResult ok() {
        return new HttpResult();
    }
}
