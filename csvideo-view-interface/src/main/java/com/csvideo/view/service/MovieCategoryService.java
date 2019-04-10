package com.csvideo.view.service;

import com.csvideo.pojo.MovieCategory;

import java.util.List;

/**
 * Created by asus on 2019/3/15.
 */
public interface MovieCategoryService {
    /**
     * 查询出所有类别
     */
    public List<MovieCategory> findAll();


}
