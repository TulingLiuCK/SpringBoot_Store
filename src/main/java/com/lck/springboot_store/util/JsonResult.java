package com.lck.springboot_store.util;

import lombok.Data;

import java.io.Serializable;

/***
 #Create by LCK on 2022/1/28
 # 用法:状态码、状态描述信息、数据。 这部分功能封装一个类中，将这类作为方法返回值，返回给前端浏览器。  将用户数值插入给客户端
 */
@Data
public class JsonResult<E> implements Serializable {
    //响应的状态码
    private Integer state;
    //描述信息
    private String message;
    //数据
    private E data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }

    public JsonResult(Throwable e){
        this.message = e.getMessage();
    }
}
