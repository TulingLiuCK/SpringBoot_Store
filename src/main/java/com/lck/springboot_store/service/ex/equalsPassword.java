package com.lck.springboot_store.service.ex;

/***
 #Create by LCK on 2022/1/30
 # 用法:
 */
public class equalsPassword extends ServiceException{
    public equalsPassword() {
        super();
    }

    public equalsPassword(String message) {
        super(message);
    }

    public equalsPassword(String message, Throwable cause) {
        super(message, cause);
    }

    public equalsPassword(Throwable cause) {
        super(cause);
    }

    protected equalsPassword(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
