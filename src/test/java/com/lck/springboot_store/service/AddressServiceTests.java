package com.lck.springboot_store.service;

import com.lck.springboot_store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***
 #Create by LCK on 2022/2/3
 # 用法:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressServiceTests {
    @Autowired
    IAddressService addressService;

    @Test
    public void addNewAdress(){
        Address address = new Address();
        address.setName("刘崇康");
        address.setAddress("河南濮阳");
        address.setPhone("12487124");
        addressService.addNewAddress(10, "liuchongkang", address);
    }
    @Test
    public void setDefault(){
        addressService.setDefault(11, 10, "管理员");
    }
    @Test
    public void delete(){
        addressService.delete(10, 10, "liuchongkang");
    }
}
