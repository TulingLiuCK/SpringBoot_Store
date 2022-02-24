package com.lck.springboot_store.mapper;

import com.lck.springboot_store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/***
 #Create by LCK on 2022/1/28
 # 用法:用户模块的接口
 */
//@Mapper  不建议，建议集中注册
public interface UserMapper {

    /**
     * @param user 用户的数据
     * @return: java.lang.Integer 受影响的行数
     */
    Integer insert(User user);

    /**
     * @param username 用户名
     *                 根据用户名来查询用户数据
     * @return: com.lck.springboot_store.entity.User
     */
    User findByUsername(String username);

    /**
     * 根据用户的uid来修改用户密码
     *
     * @param uid          用户的id
     * @param password     用户输入的新密码
     * @param modifieduser 表示修改的执行者
     * @param modifiedTime 表示修改的时间
     */
    Integer updatePasswordByUid(Integer uid, String password, String modifieduser, Date modifiedTime);

    /**
     * 根据用户的id查询用户的数据
     *
     * @param uid 如果找到了返回对象，反之返回null
     */
    User findByUid(Integer uid);

    /**
     * 更新用户的方法
     *
     * @param user
     */
    Integer updateInfoByUid(User user);


    /**
     * 根据用户uid来修改用户的头像 ("@Param") SQL映射文件中#{}占位符的变量名，解决的问题，当sql语句的占位符 和映射的接口方法参数名不一致时间
     * 可以使用@Param来接表示映射的关系
     * @param uid
     * @param avatar
     * @param modifiedUser
     * @param modifiedTime
     */
    Integer updateAvatarByUid(Integer uid, String avatar, String modifiedUser, Date modifiedTime);




}
