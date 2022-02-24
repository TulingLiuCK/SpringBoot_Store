package com.lck.springboot_store.service.ex;

/***
 #Create by LCK on 2022/1/28
 # 用法:业务层异常的基类    直接抛出    throws new ServiceException()  无参形式
 throws new ServiceException("义务层的异常)  带参
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
