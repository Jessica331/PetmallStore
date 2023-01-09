package com.wangyp.petmall.util.exception;

/**
 * @Author: Wangyp
 * @Date: 2023/1/3 20:45
 * @Description: * 上传的文件状态异常
 */
public class FileStateException extends FileUploadException {
    public FileStateException() {
        super();
    }

    public FileStateException(String message) {
        super(message);
    }

    public FileStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileStateException(Throwable cause) {
        super(cause);
    }

    protected FileStateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
