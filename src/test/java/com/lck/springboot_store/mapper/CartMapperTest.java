package com.lck.springboot_store.mapper;

import com.lck.springboot_store.entity.Cart;
import com.lck.springboot_store.vo.CartVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/***
 #Create by LCK on 2022/2/5
 # 用法:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartMapperTest {
    @Autowired
    CartMapper cartMapper;
    @Test
    public void isnert(){
        Cart cart = new Cart();
        cart.setUid(1);
        cart.setPid(2);
        cart.setNum(3);
        cart.setPrice(4L);
        Integer rows = cartMapper.insert(cart);
        System.out.println(rows);
    }

    @Test
    public void updateNumByCid(){
        Integer rows = cartMapper.updateNumByCid(5, 10, "管理员",new Date() );
        System.out.println(rows);
    }

    @Test
    public void findByUidAndPid(){
        Cart byUidAndPid = cartMapper.findByUidAndPid(1, 2);
        System.out.println(byUidAndPid);
    }
    @Test
    public void findByUidCarts(){
        List<CartVO> byUidCarts = cartMapper.findByUidCarts(10);
        for (CartVO byUidCart : byUidCarts) {
            System.out.println(byUidCart);
        }
    }
    @Test
    public void findByCidCart(){
        Cart byCidCart = cartMapper.findByCid(8);
        System.out.println(byCidCart);
    }

    @Test
    public void findVOByCid(){
        Integer[] cids= {1,2,3,30,40};
        System.out.println(cartMapper.findVOByCid(cids));
    }
    @Test
    public void delete(){
        cartMapper.delele(11);
    }

}
