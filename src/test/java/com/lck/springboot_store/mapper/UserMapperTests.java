package com.lck.springboot_store.mapper;

import com.lck.springboot_store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/***
 #Create by LCK on 2022/1/28
 # 用法:
 */
@SpringBootTest
@RunWith(SpringRunner.class)   //@RunWith 表示启动这个单元测试类
public class UserMapperTests {
    @Autowired
    UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        Integer insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void findByUsername() {
        User admin = userMapper.findByUsername("admin");
        System.out.println(admin);
    }

    @Test
    public void fupdatePasswordByUid() {
        userMapper.updatePasswordByUid(1,"qqq","qqqq", new Date());
    }

    @Test
    public void findByUid() {
        System.out.println(userMapper.findByUid(7));

    }
    @Test
    public void updateInfoByUid(){
        User user = new User();
        user.setUid(4);
        user.setPhone("123123123");
        user.setEmail("123@qq.com");
        user.setGender(1);
        userMapper.updateInfoByUid(user);
    }

    @Test
    public void updateAvatarByUid(){
        userMapper.updateAvatarByUid(10, "/upload/avatar", "管理员", new Date());
    }
}
