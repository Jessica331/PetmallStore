package com.wangyp.petmall.util.exception;

/**
 * @Author: Wangyp
 * @Date: 2023/1/9 17:59
 * @Description: *
 */
public class OrderNotExistsException extends ServiceException{

    public OrderNotExistsException() {
        super();
    }

    public OrderNotExistsException(String message) {
        super(message);
    }

    public OrderNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public OrderNotExistsException(Throwable cause) {
        super(cause);
    }

    protected OrderNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
