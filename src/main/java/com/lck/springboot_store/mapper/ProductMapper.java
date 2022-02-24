package com.lck.springboot_store.mapper;

import com.lck.springboot_store.entity.Product;

import java.util.List;

/***
 #Create by LCK on 2022/2/5
 # 用法:
 */
public interface ProductMapper {

    /**
    *描述:查询所有热销商品
    *@Param []
    *@return java.util.List<com.lck.springboot_store.entity.Product>
     */
    List<Product> findHotList();

    Product findById(Integer id);

    List<Product> findNewList();
}
