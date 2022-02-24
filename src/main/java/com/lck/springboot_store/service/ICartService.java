package com.lck.springboot_store.service;

import com.lck.springboot_store.vo.CartVO;

import java.util.List;

/***
 #Create by LCK on 2022/2/5
 # 用法:处理商品数据
 */
public interface ICartService {

    /*
    *描述:将商品添加到购物车
    *@Param [uid, pid, amount, usrename]
    *@return void
    */
    void addToCart(Integer uid,Integer pid,Integer amount,String usrename);


    List<CartVO> getVOByUid(Integer uid);

    /**
    *描述:更新用户的购物车数据的数量
    *@Param [cid, uid, username]
    *@return java.lang.Integer 增加成功后新的数量
     */
    Integer addNum(Integer cid,Integer uid,String username);

    Integer reduce(Integer cid,Integer uid,String username);

    List<CartVO> getVOByCid(Integer uid,Integer[] cids);

    void deleteToCart(Integer uid,Integer cid);
}
