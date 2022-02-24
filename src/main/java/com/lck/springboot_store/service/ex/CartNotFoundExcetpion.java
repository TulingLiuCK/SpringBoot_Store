package com.lck.springboot_store.service.ex;

/***
 #Create by LCK on 2022/2/6
 # 用法:
 */
public class CartNotFoundExcetpion extends ServiceException{

    public CartNotFoundExcetpion() {
    }

    public CartNotFoundExcetpion(String message) {
        super(message);
    }

    public CartNotFoundExcetpion(String message, Throwable cause) {
        super(message, cause);
    }

    public CartNotFoundExcetpion(Throwable cause) {
        super(cause);
    }

    public CartNotFoundExcetpion(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
