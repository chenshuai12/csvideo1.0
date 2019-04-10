package com.csvideo.view.service;

import com.csvideo.entity.PageResult;
import com.csvideo.pojo.Movies;

import java.util.List;


/**
 * Created by asus on 2019/3/15.
 */
public interface MoviesService {
    /**
     * 上传电影
     */
    public void add(Movies movies);

    /**
     * 封禁
     */
    public void update(Movies movies);

    /**
     * 查找所有电影
     */
    public PageResult findPage(int pageNum, int pageSize,String moviesStatu);

    /**
     * 根据id查询实体
     */
    public List<Movies> findOne(String moviesId);

    /**
     * 条件查询
     */
    public PageResult findPage(Movies movies,int pageNum,int pageSize);
    public List<Movies> findList(Movies movies);
    /**
     * 删除电影
     */
    public void delete(String moviesId);

}
