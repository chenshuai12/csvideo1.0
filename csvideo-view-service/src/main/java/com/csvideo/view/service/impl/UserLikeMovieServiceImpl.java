package com.csvideo.view.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csvideo.dao.MoviesMapper;
import com.csvideo.dao.UserLikeMovieMapper;
import com.csvideo.dao.UserMapper;
import com.csvideo.entity.PageResult;
import com.csvideo.pojo.MoviesExample;
import com.csvideo.pojo.UserFans;
import com.csvideo.pojo.UserLikeMovie;
import com.csvideo.pojo.UserLikeMovieExample;
import com.csvideo.view.service.UserLikeMovieService;

import java.util.UUID;
import com.csvideo.pojo.UserLikeMovieExample.Criteria;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by asus on 2019/3/15.
 */
@Service
@Transactional
public class UserLikeMovieServiceImpl implements UserLikeMovieService {
    @Autowired
    private UserLikeMovieMapper userLikeMovieMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MoviesMapper moviesMapper;
    @Override
    public void add(String userId, String movieId) {
//        保存关系
        UserLikeMovie userLikeMovie = new UserLikeMovie();
        userLikeMovie.setMovieId(movieId);
        userLikeMovie.setUserId(userId);
        userLikeMovie.setUserLikeMovieId(UUID.randomUUID().toString());
        userLikeMovieMapper.insert(userLikeMovie);

//        点赞数+1
        String id =  moviesMapper.findUserId(movieId);
        userMapper.addPraise(id);


    }

    @Override
    public PageResult findAll(String userId,int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        UserLikeMovieExample example = new UserLikeMovieExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        Page<UserLikeMovie> page = (Page<UserLikeMovie>) userLikeMovieMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }
}
