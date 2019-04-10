package com.csvideo.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.PageResult;
import com.csvideo.entity.Result;
import com.csvideo.pojo.UserReport;
import com.csvideo.pojo.VideosReport;
import com.csvideo.view.service.VideosReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/videosReport")
public class VideosReportController {
    @Reference
    private VideosReportService videosReportService;

    @RequestMapping("/getAll")
    public PageResult find(int page ,int rows){
        return videosReportService.find(page,rows);
    }

    @RequestMapping("/delete")
    public Result delete( String videosReportId){
        VideosReport videosReport = new VideosReport();
        videosReport.setVideoReportId(videosReportId);
        try {
            videosReportService.delate(videosReport);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
}
