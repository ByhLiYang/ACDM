package com.hq.acdm.exception;

/**
 * @author LiFaQiang
 * @date 2018/12/05 15:46
 * @Description
 */
public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException() {
        super();
    }

    public LinkNotFoundException(String message) {
        super(message);
    }

    public LinkNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public LinkNotFoundException(Throwable cause) {
        super(cause);
    }

    protected LinkNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
