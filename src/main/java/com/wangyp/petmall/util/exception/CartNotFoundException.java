package com.wangyp.petmall.util.exception;

/**
 * @Author: Wangyp
 * @Date: 2023/1/4 11:07
 * @Description: *
 */
public class CartNotFoundException extends ServiceException {

    public CartNotFoundException() {
        super();
    }

    public CartNotFoundException(String message) {
        super(message);
    }

    public CartNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CartNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CartNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
