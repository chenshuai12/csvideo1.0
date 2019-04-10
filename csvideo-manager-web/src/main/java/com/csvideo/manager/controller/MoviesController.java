package com.csvideo.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.PageResult;
import com.csvideo.entity.Result;
import com.csvideo.pojo.Movies;
import com.csvideo.pojo.Videos;
import com.csvideo.view.service.MoviesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/movies")
public class MoviesController {
    @Reference
    private MoviesService moviesService;


    /**
     * 根据状态查询电影
     * @param page
     * @param rows
     * @param moviesStatu
     * @return
     */
    @RequestMapping("/getAll")
    public PageResult getAll(int page,int rows,String moviesStatu){
        return moviesService.findPage(page,rows,moviesStatu);
    }
    /**
     * 根据用户id查询电影
     */
    @RequestMapping("/getByUserId")
    public List<Movies> getByUserId(String userId){
        Movies movies = new Movies();
        movies.setUserId(userId);
        return moviesService.findList(movies);
    }
    /**
     * 修改电影
     */
    @RequestMapping("/update")
    public Result update(@RequestBody Movies movies){
        try {
            moviesService.update(movies);
            return new Result(true,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }
    /**
     * 根据电影id查找电影
     */
    @RequestMapping("/getByMoviesId")
    public Movies getById(String moviesId){
        return moviesService.findOne(moviesId).get(0);
    }
    @RequestMapping("/getByMoviesIds")
    public List<Movies> getByIds(String moviesId){
        return moviesService.findOne(moviesId);
    }
}
