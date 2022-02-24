package com.lck.springboot_store.service;

import com.lck.springboot_store.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***
 #Create by LCK on 2022/2/6
 # 用法:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderServiceTest {
    @Autowired
    IOrderService orderService;

    @Test
    public void create(){
        Integer aid = 13;
        Integer[] cids = {9};
        Integer uid = 10;
        String username = "订单管理员";
        Order order = orderService.create(aid, cids, uid, username);
        System.out.println(order);
    }

}
