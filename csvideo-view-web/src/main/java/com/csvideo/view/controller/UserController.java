package com.csvideo.view.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.Result;
import com.csvideo.pojo.User;
import com.csvideo.view.service.UserService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.csvideo.util.FastDFSClient;

import java.util.List;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/user")

public class UserController {
    @Reference
    private UserService userService;
    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;//文件服务器地址
    /**
     * 登录
     */
    @RequestMapping("/getByIdCard")
    public User getByIdCard(@RequestBody User user){
        return userService.login(user);
    }
    /**
     * 修改头像
     */
    @RequestMapping("/updateFace")
    public Result updateFace(String userId, @RequestParam("file") MultipartFile file) throws Exception{
        User user = new User();
        user.setUserId(userId);
        //1、取文件的扩展名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            //2、创建一个FastDFS客户端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            //3、执行上传处理
            String path = fastDFSClient.uploadFile(file.getBytes(),extName);
            //4、拼接返回的url和ip地址，拼装成完整的url
            String url = FILE_SERVER_URL + path;
            user.setUserPhoto(url);
            userService.update(user);
            return new Result(true,"上传成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"上传失败");
        }
    }
    /**
     * 修改普通字段
     */
    @RequestMapping("/update")
    public Result update(@RequestBody User user){
       try {
           userService.update(user);
           return new Result(true,"修改成功");
       }catch (Exception e){
           e.printStackTrace();
           return new Result(false,"修改失败");
       }
    }
    /**
     * 注册
     */
    @RequestMapping("/add")
    public User add(@RequestBody User user){
        userService.add(user);
        return user;
    }
    /**
     *查找
     */
    @RequestMapping(value = "/getByUserId")
    public List<User> getByUserId(String userId){
        return userService.findOne(userId);
    }

}
