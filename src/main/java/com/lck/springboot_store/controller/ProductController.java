package com.lck.springboot_store.controller;

import com.lck.springboot_store.entity.Product;
import com.lck.springboot_store.service.IProductService;
import com.lck.springboot_store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 #Create by LCK on 2022/2/5
 # 用法:
 */
@RestController
@RequestMapping("products")
public class ProductController extends BaseController{
    @Autowired
    IProductService productService;

    @RequestMapping("hot_list")
    public JsonResult<List<Product>> getHotList(){
        List<Product> data = productService.findHotList();
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("new_list")
    public JsonResult<List<Product>> getNewList(){
        List<Product> data = productService.findNewList();
        return new JsonResult<>(ok,data);
    }



    @RequestMapping("{id}/details")
    public JsonResult<Product> getById(@PathVariable("id") Integer id){
        Product data = productService.findById(id);
        return new JsonResult<>(ok,data);
    }
}
