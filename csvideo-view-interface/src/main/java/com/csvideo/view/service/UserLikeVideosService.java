package com.csvideo.view.service;

import com.csvideo.entity.PageResult;

/**
 * Created by asus on 2019/3/15.
 */
public interface UserLikeVideosService {
    /**
     * 点赞视频
     */
    public void add(String userId,String videoId);
    /**
     * 查找所有点赞视频
     */
    public PageResult findAll(String userId,int pageNum,int pageSize);
}
