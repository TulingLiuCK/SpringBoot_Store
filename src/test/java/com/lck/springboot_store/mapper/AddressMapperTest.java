package com.lck.springboot_store.mapper;

import com.lck.springboot_store.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/***
 #Create by LCK on 2022/2/3
 # 用法:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTest {
    @Autowired
    AddressMapper addressMapper;

    @Test
    public void insert() {
        Address address = new Address();
        address.setUid(18);
        address.setName("admin");
        address.setPhone("17858802974");
//        address.setAddress("雁塔区");
        Integer rows = addressMapper.insert(address);
        System.out.println("rows=" + rows);
    }

    @Test
    public void countByUid() {
        Integer uid = 18;
        Integer count = addressMapper.countByUid(uid);
        System.out.println("count=" + count);
    }

    @Test
    public void findByUidAddresses() {
        List<Address> byUidAddresses = addressMapper.findByUid(10);
        for (Address byUidAddress : byUidAddresses) {
            System.out.println(byUidAddress);
        }
    }

    @Test
    public void getByUid() {
        List<Address> byUid = addressMapper.findByUid(10);
        System.out.println(byUid);
    }

    @Test
    public void findByAid(){
        Address byAid = addressMapper.findByAid(4);
        System.out.println(byAid);
    }
    @Test
    public void updateNoDefault(){
        Integer integer = addressMapper.updateNonDefault(10);
        System.out.println(integer);
    }
    @Test
    public void updateDefaultByAid(){
        addressMapper.updateDefaultByAid(4, "管理员", new Date());
    }

    @Test
    public void deleteByAid(){
        Integer integer = addressMapper.deleteByAid(8);
        System.out.println(integer);
    }
    @Test
    public void findLastModified(){
        Address lastModified = addressMapper.findLastModified(10);
        System.out.println(lastModified);
    }

    @Test
    public void update(){
        Address address = new Address();

        addressMapper.updateAddress(13,address);

    }
}
