package com.lck.springboot_store.service;

import com.lck.springboot_store.mapper.CartMapper;
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
public class CartServiceTest {
    @Autowired
    ICartService cartService;

    @Test
    public void addToCart(){
        cartService.addToCart(11,10000003, 15, "sdaf");
    }
    @Test
    public void delete(){
        cartService.deleteToCart(1, 1);
    }
}
