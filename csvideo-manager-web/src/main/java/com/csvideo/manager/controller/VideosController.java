package com.csvideo.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.PageResult;
import com.csvideo.entity.Result;
import com.csvideo.pojo.Movies;
import com.csvideo.pojo.Videos;
import com.csvideo.view.service.VideosService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/videos")

public class VideosController {
    @Reference
    private VideosService videosService;

    /**
     * 根据状态查询短视频
     * @param page
     * @param rows
     * @param videosStatu
     * @return
     */
    @RequestMapping("/getAll")
    public PageResult getAll(int page,int rows,String videosStatu){
        return videosService.findPage(page,rows,videosStatu);
    }
    /**
     * 根据id，状态，发布，禁播
     */
    @RequestMapping("/getByStatu")

    public List<Videos> getByStatu(String userId){
        return videosService.findList(userId);
    }
    /**
     * 修改短视频
     */
    @RequestMapping("/update")
    public Result update(@RequestBody  Videos videos){
        try {
            videosService.update(videos);
            return new Result(true,"修改成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"修改失败");
        }
    }
    /**
     * 根据视频id查询视频
     */
    @RequestMapping("/getByVideosId")
    public Videos getById(String videosId){
        return videosService.findOne(videosId).get(0);
    }
    @RequestMapping("/getByVideosIds")
    public List<Videos> getByIds(String videosId){
        return videosService.findOne(videosId);
    }
}
