package com.lck.springboot_store.service;

import com.lck.springboot_store.entity.Order;

/***
 #Create by LCK on 2022/2/6
 # 用法:
 */
public interface IOrderService {
    /**
    *描述:创建订单
    *@Param [aid, cids, uid, username]
    *@return com.lck.springboot_store.entity.Order
     */
    Order create(Integer aid,Integer[] cids,Integer uid,String username);

}
