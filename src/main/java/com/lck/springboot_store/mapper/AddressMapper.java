package com.lck.springboot_store.mapper;

import com.lck.springboot_store.entity.Address;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/***
 #Create by LCK on 2022/2/3
 # 用法:收获地址
 */
public interface AddressMapper {
    /*
     *描述: 插入用户的收获地址
     *@Param [address]
     *@return java.lang.Integer  受影响的行数。
     */
    Integer insert(Address address);

    /*
     *描述:根据用户的id统计地址数量
     *@Param [uid]
     *@return java.lang.Integer 返回值表示当前用户的收货地址总数
     */
    Integer countByUid(Integer uid);


    /**
     * 描述: 根据用户的id查询用户的收货地址数据
     *
     * @param uid
     */
    List<Address> findByUid(Integer uid);

    /**
    *描述: 根据aid查询收货地址数据
    *@Param [aid]
    *@return com.lck.springboot_store.entity.Address
     */
    Address findByAid(Integer aid);

    /**
    *描述:根据用户的uid来修改用户的收货地址默认情况
    *@Param [uid]
    *@return java.lang.Integer
     */
    Integer updateNonDefault(Integer uid);

    Integer updateDefaultByAid(@Param("aid") Integer aid, String modifiedUser, Date modifiedTime);

    /**
    *描述:根据收货地址id删除收货地址数据
    *@Param [aid]
    *@return java.lang.Integer
     */
    Integer deleteByAid(Integer aid);

    /**
    *描述:根据用户uid来查询当前用户最后一次被修改的收货地址数据
    *@Param [uid]
    *@return com.lck.springboot_store.entity.Address
     */
    Address findLastModified(Integer uid);

    void updateAddress(Integer aid,Address address);

}
