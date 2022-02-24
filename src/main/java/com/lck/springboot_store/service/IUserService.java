package com.lck.springboot_store.service;

import com.lck.springboot_store.entity.User;

/***
 #Create by LCK on 2022/1/28
 # 用法: 用户模块业务层接口
 */
public interface IUserService {

    /**
     * 用户注册方法
     *
     * @param user 用户的数据对象
     * @return: void
     */
    void reg(User user);

    /**
     * @param username 用户名
     * @param password 密码
     * @return: com.lck.springboot_store.entity.User   返回一个User，可以在页面查询本账户其他信息比如头像
     */
    User login(String username, String password);

    /**
     * 修改用户密码
     *
     * @param uid
     * @param username
     * @param oldPassword
     * @param newPassword
     */
    void changePassword(Integer uid, String username, String oldPassword, String newPassword);

    /**
     * 根据用户的id查询用户的信息
     *
     * @param uid
     */
    User getByUid(Integer uid);

    /**
     * 更新用户的操作
     *
     * @param uid      session中的uid
     * @param username session中的username
     * @param user
     */
    void changeInfo(Integer uid, String username, User user);

    /*
     *描述: 修改用户的头像
     *@Param [uid, avatar, username]  avatar用户头像的路径
     *@return void
     */
    void changeAvatar(Integer uid, String avatar, String username);
}
