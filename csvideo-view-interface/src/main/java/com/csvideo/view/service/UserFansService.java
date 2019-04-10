package com.csvideo.view.service;

import com.csvideo.entity.PageResult;
import com.csvideo.pojo.User;

import java.util.List;

/**
 * Created by asus on 2019/3/15.
 */
public interface UserFansService {
    /**
     * 查询用户所有粉丝
     */
    public PageResult findByUserId(User user,int pageNum,int pageSize);
    /**
     * 查询用户所有关注的人
     */
    public PageResult findByFansId(User user,int pageNum,int pageSize);
    /**
     * 增加关注
     */
    public void add(String userId, String fansId);
    /**
     * 删除关注
     */
    public void delate(String userId,String fansId);
}
