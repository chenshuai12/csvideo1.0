package com.csvideo.view.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.PageResult;
import com.csvideo.entity.Result;
import com.csvideo.view.service.UserLikeMovieService;
import com.csvideo.view.service.UserLikeVideosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/userLikeMovies")

public class UserLikeMovieController {
    @Reference
    private UserLikeMovieService userLikeMovieService;

    /**
     * 点赞
     */
    @RequestMapping("/add")

    public Result add(String userId, String moviesId){
        try{
            userLikeMovieService.add(userId,moviesId);
            return new Result(true,"点赞成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"点赞失败");
        }
    }

    /**
     * 查找喜欢的视频
     */
    @RequestMapping("/getAll")

    public PageResult getAll(String userId, int pageNum, int pagerows){
        return userLikeMovieService.findAll(userId, pageNum, pagerows);
    }
}
