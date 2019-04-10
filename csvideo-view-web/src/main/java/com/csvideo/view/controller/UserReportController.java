package com.csvideo.view.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.Result;
import com.csvideo.pojo.UserReport;
import com.csvideo.view.service.UserReportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/userReport")

public class UserReportController {
    @Reference
    private UserReportService userReportService;

    /**
     * 举报用户
     */
    @RequestMapping("/add")

    public Result add(@RequestBody UserReport user_report){
        try {
            userReportService.add(user_report);
            return new Result(true,"举报成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"举报失败");
        }
    }
}
