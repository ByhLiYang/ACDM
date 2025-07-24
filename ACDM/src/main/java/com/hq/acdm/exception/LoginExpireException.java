package com.hq.acdm.exception;

/**
 * @Author: lizhifeng
 * @Date: 2018/8/18
 * @Description:
 */
public class LoginExpireException extends RuntimeException {
    public LoginExpireException() {
        super();
    }

    public LoginExpireException(String message) {
        super(message);
    }

    public LoginExpireException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginExpireException(Throwable cause) {
        super(cause);
    }

    protected LoginExpireException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
