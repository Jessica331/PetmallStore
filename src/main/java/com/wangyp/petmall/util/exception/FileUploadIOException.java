package com.wangyp.petmall.util.exception;

/**
 * @Author: Wangyp
 * @Date: 2023/1/3 20:45
 * @Description: 上传文件时读写异常
 */
public class FileUploadIOException extends FileUploadException {

    public FileUploadIOException() {
        super();
    }

    public FileUploadIOException(String message) {
        super(message);
    }

    public FileUploadIOException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileUploadIOException(Throwable cause) {
        super(cause);
    }

    protected FileUploadIOException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
