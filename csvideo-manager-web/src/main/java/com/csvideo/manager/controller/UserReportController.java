package com.csvideo.manager.controller;

import com.csvideo.entity.PageResult;
import com.csvideo.entity.Result;
import com.csvideo.pojo.UserReport;
import com.csvideo.view.service.UserReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;


/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/userReport")
public class UserReportController {
    @Reference
    private UserReportService userReportService;

    @RequestMapping("/findAll")
    public PageResult findAll(int page,int rows){
        return userReportService.find(page,rows);
    }
    @RequestMapping("/delete")
    public Result delete( String userReportId){
        UserReport userReport = new UserReport();
        userReport.setUserReportId(userReportId);
        try {
            userReportService.delate(userReport);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
}
