package com.lck.springboot_store.controller;

import com.lck.springboot_store.service.ICartService;
import com.lck.springboot_store.util.JsonResult;
import com.lck.springboot_store.vo.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/***
 #Create by LCK on 2022/2/6
 # 用法:
 */
@RestController
@RequestMapping("carts")
public class CartController extends BaseController{
    @Autowired
    ICartService cartService;

    @RequestMapping("add_to_cart")
    public JsonResult<Void> addToCart(Integer pid, Integer amount, HttpSession session){

        cartService.addToCart(getudiFromSession(session),pid,amount,getUsernameFromSession(session));

        return new JsonResult<>(ok);
    }

    @RequestMapping({"","/"})
    public JsonResult<List<CartVO>> getVoByUid(HttpSession session){
        List<CartVO> data = cartService.getVOByUid(getudiFromSession(session));
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("{cid}/num/add")
    public JsonResult<Integer> addNum(@PathVariable("cid")Integer cid, HttpSession session){
        Integer data = cartService.addNum(cid, getudiFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(ok,data);
    }
    @RequestMapping("{cid}/num/reduce")
    public JsonResult<Integer> reduceNum(@PathVariable("cid")Integer cid, HttpSession session){
        Integer data = cartService.reduce(cid, getudiFromSession(session), getUsernameFromSession(session));
        return new JsonResult<>(ok,data);
    }

    @RequestMapping("list")
    public JsonResult<List<CartVO>> getVOByCid(Integer[] cids,HttpSession session){
        List<CartVO> data = cartService.getVOByCid(getudiFromSession(session), cids);
        return new JsonResult<>(ok,data);
    }
    @RequestMapping("{cid}/delete")
    public JsonResult<Void> deleteByCid(HttpSession session,@PathVariable("cid")Integer cid){
        cartService.deleteToCart(getudiFromSession(session),cid);
        return new JsonResult<>(ok);

    }

}
