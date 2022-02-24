package com.lck.springboot_store.service;

import com.lck.springboot_store.entity.Product;

import java.util.List;

/***
 #Create by LCK on 2022/2/5
 # 用法:
 */
public interface IProductService {
    List<Product> findHotList();

    Product findById(Integer id);

    List<Product> findNewList();
}
