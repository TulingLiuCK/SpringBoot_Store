package com.lck.springboot_store.controller;

import com.lck.springboot_store.entity.Order;
import com.lck.springboot_store.service.IOrderService;
import com.lck.springboot_store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/***
 #Create by LCK on 2022/2/6
 # 用法:
 */
@RestController
@RequestMapping("orders")
public class OrderController extends BaseController{
    @Autowired
    IOrderService orderService;

    @RequestMapping("create")
    public JsonResult<Order> create(Integer aid, Integer[] cids, HttpSession session){
        Order data = orderService.create(aid, cids, getudiFromSession(session), getUsernameFromSession(session));
        System.out.println(data);
        return new JsonResult<>(ok,data);
    }
}
