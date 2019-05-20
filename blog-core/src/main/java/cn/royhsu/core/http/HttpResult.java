package cn.royhsu.core.http;

/**
 * HTTP结果封装
 *
 * @author Ethan Liu
 * @since 2019/4/30 11:09
 */

public class HttpResult<T> {
    private int code = 200;
    private String msg;
    private T data;

    public HttpResult() {

    }

    public static<T> HttpResult<T> error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

    public static<T> HttpResult<T> error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static<T> HttpResult<T> error(int code, String msg) {
        HttpResult<T> r = new HttpResult<>();
        r.setCode(code);
        r.setMsg(msg);
        return r;
    }

    public static HttpResult ok(String msg) {
        HttpResult r = new HttpResult();
        r.setMsg(msg);
        return r;
    }

    public static<T>  HttpResult<T> ok(T data) {
        HttpResult<T> r = new HttpResult<>();
        r.setData(data);
        return r;
    }

    public static HttpResult ok() {
        return new HttpResult();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
