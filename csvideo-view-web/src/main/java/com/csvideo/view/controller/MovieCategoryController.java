package com.csvideo.view.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.pojo.MovieCategory;
import com.csvideo.view.service.MovieCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/MovieCategory")
public class MovieCategoryController {
    @Reference
    private MovieCategoryService movieCategoryService;

    @RequestMapping("/getAll")
    public List<MovieCategory> getAll(){
        return movieCategoryService.findAll();
    }
}
