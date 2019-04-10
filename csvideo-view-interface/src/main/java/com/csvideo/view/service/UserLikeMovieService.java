package com.csvideo.view.service;

import com.csvideo.entity.PageResult;

/**
 * Created by asus on 2019/3/15.
 */
public interface UserLikeMovieService {
    /**
     * 点赞电影
     */
    public void add(String userId,String movieId);
    /**
     * 查找所有点赞电影
     */
    public PageResult findAll(String userId,int pageNum,int pageSize);
}
