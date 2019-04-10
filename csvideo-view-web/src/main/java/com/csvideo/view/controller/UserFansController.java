package com.csvideo.view.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.PageResult;
import com.csvideo.entity.Result;
import com.csvideo.pojo.User;
import com.csvideo.view.service.UserFansService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/userFans")
public class UserFansController {
    @Reference
    private UserFansService userFansService;

    /**
     * 添加关注
     */
    @RequestMapping("/add")

    public Result add(String userId,String followId){
        try {
            userFansService.add(followId,userId);
            return new Result(true,"成功关注");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"关注失败");
        }
    }
    /**
     * 取消关注
     */
    @RequestMapping("/delete")
    public Result delete( String userId, String followId){
        try{
            userFansService.delate(followId,userId);
            return new Result(true,"取消关注成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"取消关注失败");
        }
    }
    /**
     * 查看所有关注的人
     */
    @RequestMapping("/getAllFollow")
    public PageResult getAllFollow(@RequestBody User user, int page, int rows){
        return userFansService.findByUserId(user, page, rows);
    }
    /**
     * 查看所有粉丝
     */
    @RequestMapping("/getAllFans")

    public PageResult getAllFans(@RequestBody User user,int page,int rows){
        return userFansService.findByFansId(user, page, rows);
    }
}
