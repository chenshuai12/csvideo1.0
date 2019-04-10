package com.csvideo.view.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csvideo.dao.MovieCategoryMapper;
import com.csvideo.pojo.MovieCategory;
import com.csvideo.view.service.MovieCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by asus on 2019/3/15.
 */
@Service
@Transactional
public class MovieCategoryServiceImpl implements MovieCategoryService{
    @Autowired
    private MovieCategoryMapper movieCategoryMapper;
    @Override
    public List<MovieCategory> findAll() {
        List<MovieCategory> movieCategoryServiceList = movieCategoryMapper.selectByExample(null);
        return movieCategoryServiceList;
    }
}
