package com.lck.springboot_store.service.ex;

/***
 #Create by LCK on 2022/2/3
 # 用法:表示收货地址总数超过限制的异常（最多20条）
 */
public class AddresssCountLimitException extends ServiceException{
    public AddresssCountLimitException() {
        super();
    }

    public AddresssCountLimitException(String message) {
        super(message);
    }

    public AddresssCountLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public AddresssCountLimitException(Throwable cause) {
        super(cause);
    }

    public AddresssCountLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
