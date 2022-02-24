package com.lck.springboot_store.service;

import com.lck.springboot_store.entity.District;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/***
 #Create by LCK on 2022/2/3
 # 用法:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DistrictSerivceTest {
    @Autowired
    IDistrictService districtService;

    @Test
    public void getByParent(){
        List<District> byParent = districtService.getByParent("86");
        for (District district : byParent) {
            System.out.println(district);
        }
    }
}
