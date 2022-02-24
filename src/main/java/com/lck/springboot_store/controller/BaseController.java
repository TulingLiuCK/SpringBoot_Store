package com.lck.springboot_store.controller;

import com.lck.springboot_store.controller.ex.*;
import com.lck.springboot_store.service.ex.*;
import com.lck.springboot_store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/***
 #Create by LCK on 2022/1/28
 # 用法:统一处理控制层异常
 */
public class BaseController {
    //操作成功的状态码
    public static final int ok = 200;


    //请求处理方法，这个方法的返回值就是需要传递给前端的数据
    @ExceptionHandler({ServiceException.class, FileUploadException.class}) //用于统一处理抛出的异常
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UserNameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名已经被占用");
        } else if (e instanceof UserNotFoundException) {
            result.setState(4001);
            result.setMessage("用户数据不存在");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(4002);
            result.setMessage("用户名密码错误");
        } else if (e instanceof AddresssCountLimitException) {
            result.setState(4003);
            result.setMessage("用户收货地址超出上限");
        } else if (e instanceof AddressNotFoundException) {
            result.setState(4004);
            result.setMessage("用户的收货地址数据不存在");
        } else if (e instanceof AccessDeniedException) {
            result.setState(4005);
            result.setMessage("收货地址数据非法访问");
        } else if (e instanceof ProductNotFoundException) {
            result.setState(4006);
            result.setMessage("无法获取到商品数据");
        }else if (e instanceof CartNotFoundExcetpion) {
            result.setState(4007);
            result.setMessage("购物车数据不存在");
        } else if (e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时未知异常");
        } else if (e instanceof UpdateException) {
            result.setState(5001);
            result.setMessage("更新数据时产生未知的异常");
        } else if (e instanceof equalsPassword) {
            result.setState(5001);
            result.setMessage("密码相同");
        } else if (e instanceof DeleteException) {
            result.setState(5002);
            result.setMessage("删除数据时产生未知的异常");
        } else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }
        return result;
    }

    /**
     * 获取Session对象中的uid，
     *
     * @param session
     */
    protected final Integer getudiFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 获取当前登录用户的username
     *
     * @param session
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();

    }

}
