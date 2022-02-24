package com.lck.springboot_store.service.impl;

import com.lck.springboot_store.entity.Cart;
import com.lck.springboot_store.entity.Product;
import com.lck.springboot_store.mapper.CartMapper;
import com.lck.springboot_store.mapper.ProductMapper;
import com.lck.springboot_store.service.ICartService;
import com.lck.springboot_store.service.ex.*;
import com.lck.springboot_store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

/***
 #Create by LCK on 2022/2/5
 # 用法:
 */
@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    CartMapper cartMapper;

    @Autowired
    ProductMapper productMapper;

    @Override
    public void addToCart(Integer uid, Integer pid, Integer amount, String username) {
        //查询当前要添加的这个商品是否在表中
        Cart result = cartMapper.findByUidAndPid(uid, pid);
        Date date = new Date();
        if (result == null) {
            //创建一个cart对象
            Cart cart = new Cart();
            //补全数据，作为参数传递的数据
            cart.setUid(uid);
            cart.setPid(pid);
            cart.setNum(amount);
            //价格，商品中的价格
            Product product = productMapper.findById(pid);
            cart.setPrice(product.getPrice());
            //补全4个日志
            cart.setCreatedTime(date);
            cart.setCreatedUser(username);
            cart.setModifiedTime(date);
            cart.setModifiedUser(username);
            Integer rows = cartMapper.insert(cart);
            if (rows != 1) {
                throw new InsertException("插入数据时产生未知的异常");
            }
        } else {//表示当前的商品已经在购物车中，那么更新数据
            Integer cid = result.getCid();
            Integer num = result.getNum() + amount;
            Integer rows = cartMapper.updateNumByCid(cid, num, username, date);
            if (rows != 1) {
                throw new UpdateException("更新购物车时产生未知的异常");
            }
        }
    }

    @Override
    public List<CartVO> getVOByUid(Integer uid) {
        return cartMapper.findByUidCarts(uid);
    }

    @Override
    public Integer addNum(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        if (result == null){
            throw new CartNotFoundExcetpion("购物车数据不存在");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("数据非法访问");
        }
        int num = result.getNum() + 1;
        Integer rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if (rows != 1){
            throw new UpdateException("更新数据失败");
        }
        //返回新的购物车数据总量
        return num;
    }

    @Override
    public Integer reduce(Integer cid, Integer uid, String username) {
        Cart result = cartMapper.findByCid(cid);
        int num ;
        if (result == null){
            throw new CartNotFoundExcetpion("购物车数据不存在");
        }
        if (!result.getUid().equals(uid)){
            throw new AccessDeniedException("数据非法访问");
        }
        num = result.getNum() - 1;
        if (result.getNum() <= 1){
            num = 1;
        }



        Integer rows = cartMapper.updateNumByCid(cid, num, username, new Date());
        if (rows != 1){
            throw new UpdateException("更新数据失败");
        }
        //返回新的购物车数据总量
        return num;
    }

    @Override
    public List<CartVO> getVOByCid(Integer uid,Integer[] cids) {
        List<CartVO> list = cartMapper.findVOByCid(cids);
        Iterator<CartVO> it = list.iterator();
        while (it.hasNext()){
            CartVO cartVO = it.next();
            if (!cartVO.getUid().equals(uid)){//表示当前的数据不属于当前的用户
                //从集合中移除这个元素
                list.remove(cartVO);
            }
        }
        return list;
    }

    @Override
    public void deleteToCart(Integer uid, Integer cid) {
        Integer rows = cartMapper.delele(cid);
        if (rows!=1){
            throw new UpdateException("删除数据产生未知的异常");
        }
    }


}
