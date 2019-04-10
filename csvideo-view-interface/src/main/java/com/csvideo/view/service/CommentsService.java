package com.csvideo.view.service;

import com.csvideo.entity.PageResult;
import com.csvideo.pojo.Comments;
import com.csvideo.pojo.Movies;
import com.csvideo.pojo.User;
import com.csvideo.pojo.Videos;

import java.util.List;


/**
 * Created by asus on 2019/3/15.
 */
public interface CommentsService {
    /**
     * 添加回复
     */
    public void add(Comments comments);
    /**
     * 删除回复
     */
    public void delate(String commentId);
    /**
     * 根据视频id查找不存在父评论的回复
     */
    public PageResult findByMoviesId(Movies movies, int pageNum,int pageSize);
    public PageResult findByVideosId(Videos videos,int pageNum,int pageSize);
    /**
     * 根据父回复id查找评论
     */
    public PageResult findByFatherCommentId(String fatherCommentId,int pageNum,int pageSize);

    /**
     * 根据评论人查找所有回复
     */
    public List<Comments> findByUserId(User user);
    public List<Comments> getByUserIdWithoutPage(String userId);
}
