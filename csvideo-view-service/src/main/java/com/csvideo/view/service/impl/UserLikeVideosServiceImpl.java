package com.csvideo.view.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csvideo.dao.UserLikeVideosMapper;
import com.csvideo.dao.UserMapper;
import com.csvideo.dao.VideosMapper;
import com.csvideo.entity.PageResult;
import com.csvideo.pojo.UserLikeMovieExample;
import com.csvideo.pojo.UserLikeVideos;
import com.csvideo.pojo.UserLikeVideosExample;
import com.csvideo.view.service.UserLikeVideosService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.UUID;
import com.csvideo.pojo.UserLikeVideosExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by asus on 2019/3/15.
 */
@Service
@Transactional
public class UserLikeVideosServiceImpl implements UserLikeVideosService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserLikeVideosMapper userLikeVideosMapper;
    @Autowired
    private VideosMapper videosMapper;
    @Override
    public void add(String userId, String videoId) {
//        保存关系
        UserLikeVideos userLikeVideos = new UserLikeVideos();
        userLikeVideos.setUserLikeVideosId(UUID.randomUUID().toString());
        userLikeVideos.setUserId(userId);
        userLikeVideos.setVideoId(videoId);
        userLikeVideosMapper.insert(userLikeVideos);
//        点赞数+1
        String id = videosMapper.findUserId(videoId);
        userMapper.addPraise(id);
    }

    @Override
    public PageResult findAll(String userId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        UserLikeVideosExample example = new UserLikeVideosExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        Page<UserLikeVideos> page = (Page<UserLikeVideos>) userLikeVideosMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
