package com.lck.springboot_store.mapper;

import com.lck.springboot_store.entity.Order;
import com.lck.springboot_store.entity.OrderItem;

/***
 #Create by LCK on 2022/2/6
 # 用法:
 */
public interface OrderMapper {

    /**
    *描述:插入订单数据
    *@Param [order]
    *@return java.lang.Integer
     */
    Integer insertOrder(Order order);

    /**
    *描述:插入订单商品数据
    *@Param [orderItem]
    *@return java.lang.Integer
     */
    Integer insertOrderItem(OrderItem orderItem);
}
