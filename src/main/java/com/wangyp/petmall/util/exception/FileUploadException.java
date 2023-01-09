package com.wangyp.petmall.util.exception;

/**
 * @Author: Wangyp
 * @Date: 2023/1/3 20:42
 * @Description: *
 */
public class FileUploadException extends RuntimeException  {
    public FileUploadException() {
        super();
    }

    public FileUploadException(String message) {
        super(message);
    }

    public FileUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadException(Throwable cause) {
        super(cause);
    }

    protected FileUploadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
