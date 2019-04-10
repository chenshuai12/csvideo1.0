package com.csvideo.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.PageResult;
import com.csvideo.entity.Result;
import com.csvideo.pojo.User;
import com.csvideo.pojo.UserReport;
import com.csvideo.view.service.UserFansService;
import com.csvideo.view.service.UserReportService;
import com.csvideo.view.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    private UserService userService;
    @Reference
    private UserReportService userReportService;
    //分页查找所有用户
    @RequestMapping("/getAll")
    public PageResult getAll(int page,int rows,String userStatu){
        return userService.findPage(page,rows,userStatu);
    }
    @RequestMapping("/findAll")
    public List<User> findAll(){
        return userService.findAll();
    }
    //封禁用户
    @RequestMapping(value = "/close",method = RequestMethod.POST)
    public Result close(@RequestBody User user){
        user.setUserStatu("2");
        try {
            userService.update(user);
            return new Result(true,"封禁用户成功");
        }catch (Exception e){
            e.printStackTrace();;
            return new Result(false,"封禁用户失败");
        }
    }
    //添加用户
    @RequestMapping("/add")
    public User add(@RequestBody User user){
        userService.add(user);
        return user;
    }
    /**
     *查找
     */
    @RequestMapping("/getByUserId")
    public User getByUserId(String userId){
        System.out.println("userController:"+userId);
        System.out.println("userController:"+userService.findOne(userId));
        return userService.findOne(userId).get(0);
    }
}
