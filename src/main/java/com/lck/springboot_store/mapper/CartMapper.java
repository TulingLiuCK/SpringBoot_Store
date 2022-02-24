package com.lck.springboot_store.mapper;

import com.lck.springboot_store.entity.Cart;
import com.lck.springboot_store.vo.CartVO;

import java.util.Date;
import java.util.List;

/***
 #Create by LCK on 2022/2/5
 # 用法:
 */
public interface CartMapper {

    /**
    *描述: 向购物车插入数据
    *@Param [cart]
    *@return java.lang.Integer
     */
    Integer insert(Cart cart);

    /*
    *描述: 更新购物车某件商品。
    *@Param [cid 购物车数据id,num 更新的数量, modifiedUser, modifiedTime]
    *@return java.lang.Integer
    */
    Integer updateNumByCid(Integer cid, Integer num, String modifiedUser, Date modifiedTime);

    /*
    *描述: 根据用户的id和商品的id来查询购物车中的数据
    *@Param [uid 用户id, pid 商品id]
    *@return com.lck.springboot_store.entity.Cart
    */
    Cart findByUidAndPid(Integer uid,Integer pid);

    /*
    *描述:根据用户的id和商品的id来查询购物车中的数据。
    *@Param [uid]
    *@return java.util.List<com.lck.springboot_store.vo.CartVO>
    */
    List<CartVO> findByUidCarts(Integer uid);

    /**
    *描述:根据cid来查询当前购物车这条数据是否存在了。
    *@Param [cid]
    *@return com.lck.springboot_store.entity.Cart
     */
    Cart findByCid(Integer cid);

    List<CartVO> findVOByCid(Integer[] cids);

    Integer delele(Integer cid);
}
