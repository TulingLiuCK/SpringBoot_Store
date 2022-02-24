package com.lck.springboot_store.mapper;

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
@RunWith(SpringRunner.class)   //@RunWith 表示启动这个单元测试类
public class DistrictMapperTest {

    @Autowired
    DistrictMapper districtMapper;
    @Test
    public void find(){
        List<District> byParent = districtMapper.findByParent("110100");
        for (District district : byParent) {
            System.out.println(district);
        }
    }
    @Test
    public void findNameByCode(){
        String nameByCode = districtMapper.findNameByCode("610000");
        System.out.println(nameByCode);
    }
}
