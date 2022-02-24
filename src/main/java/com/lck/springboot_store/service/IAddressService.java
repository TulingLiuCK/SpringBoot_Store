package com.lck.springboot_store.service;

import com.lck.springboot_store.entity.Address;

import java.util.List;

/***
 #Create by LCK on 2022/2/3
 # 用法: 收获地址业务层接口
 */
public interface IAddressService {

    /**
     * 描述:新增收货地址，但是uid和username需要
     *
     * @param uid
     * @param username
     * @param address
     */
    void addNewAddress(Integer uid, String username, Address address);

    /**
     * 描述: 根据用户的 id获取用户的地址信息
     *
     * @param uid
     */
    List<Address> getByUid(Integer uid);

    /**
    *描述: 修改某个用户的某条收货地址为默认收货地址
    *@Param [aid, uid, username]
    *@return void
     */
    void setDefault(Integer aid,Integer uid,String username);

    /**
    *描述:删除用户选中的收货地址数据
    *@Param [aid, uid, username]
    *@return void
     */
    void delete(Integer aid, Integer uid,String username);

    void update(Integer aid,Address address);

    /**
    *描述: 根据收货地址数据的id，查询收获地址情况
    *@Param [aid, uid]
    *@return com.lck.springboot_store.entity.Address
     */
    Address getByAid(Integer aid,Integer uid);

}
