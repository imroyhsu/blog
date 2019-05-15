package cn.royhsu.core.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ethan Liu
 * @since 2019/5/5 15:36
 */
@Getter
@Setter
public class BlogException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String msg;
    private int code = 500;

    public BlogException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public BlogException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BlogException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public BlogException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }


}
