package com.csvideo.view.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csvideo.dao.CommentsMapper;
import com.csvideo.entity.PageResult;
import com.csvideo.pojo.*;
import com.csvideo.view.service.CommentsService;

import java.util.List;
import java.util.UUID;
import com.csvideo.pojo.CommentsExample.Criteria;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by asus on 2019/3/15.
 */
@Service
@Transactional
public class CommentsServiceImpl implements CommentsService {
    @Autowired
    private CommentsMapper commentsMapper;
    @Override
    public void add(Comments comments) {
        String uuid = UUID.randomUUID().toString();
        comments.setCommentId(uuid);
        commentsMapper.insert(comments);
    }

    @Override
    public void delate(String commentId) {
        CommentsExample example = new CommentsExample();
        Criteria criteria = example.createCriteria();
        criteria.andCommentIdEqualTo(commentId);
        commentsMapper.deleteByExample(example);
    }

    @Override
    public PageResult findByMoviesId(Movies movies, int pageNum, int pageSize) {
        CommentsExample example = new CommentsExample();
        Criteria criteria = example.createCriteria();
        String moviesId = movies.getMoviesId();
        criteria.andMoviesIdEqualTo(moviesId);
        criteria.andFatherCommentIdIsNull();
        PageHelper.startPage(pageNum,pageSize);
        Page<Comments> page = (Page<Comments>) commentsMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public PageResult findByVideosId(Videos videos, int pageNum, int pageSize) {
        CommentsExample example = new CommentsExample();
        Criteria criteria = example.createCriteria();
        String videosId = videos.getVideosId();
        criteria.andVideosIdEqualTo(videosId);
        criteria.andFatherCommentIdIsNull();
        PageHelper.startPage(pageNum,pageSize);
        Page<Comments> page = (Page<Comments>) commentsMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public PageResult findByFatherCommentId(String fatherCommentId, int pageNum, int pageSize) {
        CommentsExample example = new CommentsExample();
        Criteria criteria = example.createCriteria();
        criteria.andFatherCommentIdEqualTo(fatherCommentId);
        PageHelper.startPage(pageNum,pageSize);
        Page<Comments> page = (Page<Comments>) commentsMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public List<Comments> findByUserId(User user) {
        CommentsExample example = new CommentsExample();
        Criteria criteria = example.createCriteria();
        criteria.andFromUserIdEqualTo(user.getUserId());
        return commentsMapper.selectByExample(example);
    }
    public List<Comments> getByUserIdWithoutPage(String userId){
        CommentsExample example = new CommentsExample();
        Criteria criteria = example.createCriteria();
        criteria.andFromUserIdEqualTo(userId);
        return commentsMapper.selectByExample(example);
    }
}
