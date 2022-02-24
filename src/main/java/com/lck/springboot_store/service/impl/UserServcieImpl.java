package com.lck.springboot_store.service.impl;

import com.lck.springboot_store.entity.User;
import com.lck.springboot_store.mapper.UserMapper;
import com.lck.springboot_store.service.IUserService;
import com.lck.springboot_store.service.ex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/***
 #Create by LCK on 2022/1/28
 # 用法:
 */
@Service
public class UserServcieImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void reg(User user) {
        //先判断username是否被注册过
        String username = user.getUsername();
        User result = userMapper.findByUsername(username);
        if (result != null) {
            throw new UserNameDuplicatedException("用户名被占用");
        }

        //加密密码
        String oldPassword = user.getPassword();
        //获取盐值
        String salt = UUID.randomUUID().toString().toUpperCase();
        String md5Password = getMd5Password(oldPassword, salt);
        //将加密之后的密码设置到user对象中
        user.setPassword(md5Password);


        //补全数据：保存注册时加密算法的盐值
        user.setSalt(salt);
        //补全数据is_delete 设置成0
        user.setIsDelete(0);
        //补全数据 4个日志信息段
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        Integer insert = userMapper.insert(user);
        if (insert != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    @Override
    public User login(String username, String password) {
        //根据用户名查询用户的数据是否存在，如果不存在，则抛异常
        User byUsername = userMapper.findByUsername(username);
        if (byUsername == null) {
            throw new UserNotFoundException("用户信息不存在");
        }
        //检测用户的密码是否匹配
        //1先获取到数据库中的加密之后的密码
        String oldPassword = byUsername.getPassword();
        //2、和用户传递过来的密码进行比较 将用户密码进行加密
        String salt = byUsername.getSalt();
        String newMD5Password = getMd5Password(password, salt);
        if (!newMD5Password.equals(oldPassword)) {
            throw new PasswordNotMatchException("用户密码不正确");
        }
        //判断用户是否已经删除   匹配数据库中的is_delete  如果为0没删除，如果为1则删除了 表示该用户已经不再使用改网站了
        if (byUsername.getIsDelete() == 1) {
            throw new UserNotFoundException("您已注销改用户，请重新注册");
        }
        //只把有用的信息传递出去，提升系统的性能。 防止暴露其他字段
        User user = new User();
        user.setUid(byUsername.getUid());
        user.setUsername(byUsername.getUsername());
        user.setAvatar(byUsername.getAvatar());
        //返回的对象可以辅助其他页面进行验证，比如id 头像 是否删除
        return user;


    }

    @Override
    public void changePassword(Integer uid, String username, String oldPassword, String newPassword) {
        User result = userMapper.findByUid(uid);
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }
        String oldMd5Password = getMd5Password(oldPassword, result.getSalt());

        if (!result.getPassword().equals(oldMd5Password)) {
            throw new PasswordNotMatchException("密码不正确");
        }
        //将新密码设置到数据库中
        String newmd5Password = getMd5Password(newPassword, result.getSalt());
        if (newmd5Password.equals(oldMd5Password)){
            throw new equalsPassword("不能跟原密码相同");
        }
        Integer rows = userMapper.updatePasswordByUid(uid, newmd5Password, username, new Date());
        if (rows !=1) {
            throw new UpdateException("更新数据产生未知的异常");
        }
    }

    @Override
    public User getByUid(Integer uid) {
        User result = userMapper.findByUid(uid);
        if (result==null|| result.getIsDelete() == 1){
            throw  new UserNotFoundException("用户数据不存在");
        }
        User user = new User();
        user.setUsername(result.getUsername());
        user.setPhone(result.getPhone());
        user.setEmail(result.getEmail());
        user.setGender(result.getGender());
        return user;
    }

    @Override
    public void changeInfo(Integer uid, String username, User user) {
        User result = userMapper.findByUid(uid);
        if (result==null||result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }
        user.setUid(uid);
        user.setModifiedUser(username);
        user.setModifiedTime(new Date());
        Integer rows = userMapper.updateInfoByUid(user);
        if (rows!=1){
            throw new UpdateException("更新数据时异常");
        }
    }

    @Override
    public void changeAvatar(Integer uid, String avatar, String username) {
        //查询当前的用户数据是否存在
        User result = userMapper.findByUid(uid);
        if (result == null || result.getIsDelete()==1){
            throw new UserNotFoundException("用户数据不存在");
        }
        Integer rows = userMapper.updateAvatarByUid(uid, avatar, username, new Date());
        if (rows != 1){
            throw  new UpdateException("更新用户头像产生未知的异常");
        }

    }


    private String getMd5Password(String password, String salt) {

        for (int i = 0; i < 3; i++) {
            //md5加密算法方法的调用(进行三次加密)
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }

}
