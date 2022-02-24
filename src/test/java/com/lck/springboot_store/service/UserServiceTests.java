package com.lck.springboot_store.service;

import com.lck.springboot_store.entity.User;
import com.lck.springboot_store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/***
 #Create by LCK on 2022/1/28
 # 用法:
 */
@SpringBootTest
@RunWith(SpringRunner.class)   //@RunWith 表示启动这个单元测试类
public class UserServiceTests {
    @Autowired
    IUserService userService;


    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("admin");
            user.setPassword("123123");
            userService.reg(user);
            System.out.println("ok");
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void login() {
        User login = userService.login("admin", "admin");
        System.out.println(login);
    }

    @Test
    public void changePassword() {
        userService.changePassword(9, "admin", "admin", "123123");
    }

    @Test
    public void getByUid(){
        System.out.println(userService.getByUid(9));
    }
    @Test
    public void changeInfo(){
        User user = new User();
        user.setEmail("222@qq.com");
        user.setPhone("123123123444");
        user.setGender(0);
        userService.changeInfo(1, "admin", user);

    }
    @Test
    public void chanAvatar(){
        userService.changeAvatar(10,"/upload/test.jpg", "管理员");
    }
}
