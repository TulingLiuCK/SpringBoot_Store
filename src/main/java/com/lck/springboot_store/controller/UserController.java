package com.lck.springboot_store.controller;

import com.lck.springboot_store.controller.ex.*;
import com.lck.springboot_store.entity.User;
import com.lck.springboot_store.service.IUserService;
import com.lck.springboot_store.service.ex.InsertException;
import com.lck.springboot_store.service.ex.UserNameDuplicatedException;
import com.lck.springboot_store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/***
 #Create by LCK on 2022/1/28
 # 用法:
 */
@RestController
@RequestMapping("users")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;


    /**
     * 1接受数据方式：请求处理方法的参数列表设置为pojo类型来接受前端的数据
     * SpringBoot会将前端的url地址中的参数名和pojo类的属性名进行比较，如果相同，则会注入
     *
     * @param user
     */
    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {

        userService.reg(user);

        return new JsonResult<>(ok);
    }

    /**
     * 2接受数据方式：请求处理方法的参数列表设置为非pojo类型
     * SpringBoot会直接将请求的参数名和方法的参数名直接进行比较，如果名称相同则自动依赖注入。
     *
     * @param username
     * @param password
     */
    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session) {
        User data = userService.login(username, password);
        //向session对象中完成数据的绑定（session是全局的）
        session.setAttribute("uid", data.getUid());
        session.setAttribute("username", data.getUsername());
        //获取session中绑定的数据
//        System.out.println(getudiFromSession(session));
//        System.out.println(getUsernameFromSession(session));
        return new JsonResult<>(ok, data);
    }

    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, HttpSession session) {
        Integer uid = getudiFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid, username, oldPassword, newPassword);
        return new JsonResult<>(ok);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUid(HttpSession session) {
        User data = userService.getByUid(getudiFromSession(session));
        return new JsonResult(ok, data);
    }

    @RequestMapping("change_info")
    public JsonResult<Void> changeInfo(User user, HttpSession session) {
        //user对象中有四部分数据，username、phone、email、gender
        Integer uid = getudiFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changeInfo(uid, username, user);
        return new JsonResult<>(ok);
    }
    /*设置文件上传的最大值*/
    public static final int AVATAR_MAX_SIZE = 10*1024*1024;
    /*限制上传文件的类型*/
    public static final List<String> AVATAR_TYPE = new ArrayList<>();
    static {
        AVATAR_TYPE.add("images/jpg");
        AVATAR_TYPE.add("iamges/png");
        AVATAR_TYPE.add("images/bmp");
        AVATAR_TYPE.add("images/gif");
    }

    /*
    *描述: MultiplepartFile接口是SpringMVC提供的接口，这个接口为我们包装了获取文件类型的数据（任何类型的file都可以接受）
    *@Param [session, file]
    *@return com.lck.springboot_store.util.JsonResult<java.lang.String>
    */

    @PostMapping("change_avatar")
    public JsonResult<String> changeAvatar(HttpSession session, MultipartFile file)  {
        if (file.isEmpty()){
            throw new FileEmptyException("文件为空");
        }
        if (file.getSize()>AVATAR_MAX_SIZE){
            throw new FileSizeException("文件超出限制");
        }
        String contentType = file.getContentType();
        //如果集合包含某个元素，返回true
//        if (!AVATAR_TYPE.contains(contentType)){
//            throw new FileTypeException("图片类型错误");
//        }
        //上传的文件
        String parent = session.getServletContext().getRealPath("upload");
        File dir = new File(parent);
        if (!dir.exists()){
            dir.mkdirs();//如果不存在则创建
        }
        String originalFilename = file.getOriginalFilename();
        System.out.println("originalFilename"+originalFilename);
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String filename = UUID.randomUUID().toString().toUpperCase()+suffix;
        // 创建文件对象，表示保存的头像文件
        File dest = new File(dir, filename);
        // 执行保存头像文件
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            // 抛出异常
            throw new FileStateException("文件状态异常，可能文件已被移动或删除");
        } catch (IOException e) {
            // 抛出异常
            throw new FileUploadIOException("上传文件时读写错误，请稍后重新尝试");
        }
//        String originalFilename = file.getOriginalFilename();
//        try {
//            file.transferTo(new File("D:\\ideaCode\\upload"+originalFilename));
//        } catch (IOException e) {
//           throw new FileUploadException("文件读写异常");
//        }
//        Integer uid = getudiFromSession(session);
//        String username = getUsernameFromSession(session);
        //返回头像的路径

        // 头像路径
        String avatar = "/upload/" + filename;
        // 从Session中获取uid和username
        Integer uid = getudiFromSession(session);
        String username = getUsernameFromSession(session);
        // 将头像写入到数据库中
        userService.changeAvatar(uid, avatar, username);
        return new JsonResult<>(ok,avatar);

    }







    /*@RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        //创建响应结果
        JsonResult<Void> result = new JsonResult<>();
        try {
            userService.reg(user);
            result.setState(200);
            result.setMessage("用户注册成功");
        } catch (UserNameDuplicatedException e) {
            result.setState(4000);
            result.setMessage("用户名被占用");
        } catch (InsertException e){
            result.setState(5000);
            result.setMessage("插入时出现未知的异常");
        }
        return  result;
    }*/
}
