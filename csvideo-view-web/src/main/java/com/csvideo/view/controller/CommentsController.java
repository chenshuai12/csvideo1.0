package com.csvideo.view.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.PageResult;
import com.csvideo.entity.Result;
import com.csvideo.pojo.Comments;
import com.csvideo.pojo.Movies;
import com.csvideo.pojo.Videos;
import com.csvideo.view.service.CommentsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/comment")
public class CommentsController {
    @Reference
    private CommentsService commentsService;

    /**
     * 查看该短视频下的父评论
     */
    @RequestMapping("/getByVideosId")
    public PageResult getByVideosId( String videosId, int page, int rows){
        Videos videos = new Videos();
        videos.setVideosId(videosId);
        return commentsService.findByVideosId(videos,page,rows);
    }
    /**
     * 查看该电影下的父评论
     */
    @RequestMapping("/getByMoviesId")
    public PageResult getByMoviesId( String moviesId,int page, int rows){
        Movies movies = new Movies();
        movies.setMoviesId(moviesId);
        return commentsService.findByMoviesId(movies,page,rows);
    }
    /**
     * 添加评论
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Comments comments){
        try {
            commentsService.add(comments);
            return new Result(true,"回复成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"回复失败");
        }
    }
    /**
     * 查看子评论
     */
    @RequestMapping("/getByFatherCommentId")
    public PageResult getByFatherCommentId( String fatherCommentId,int page,int rows){
        return commentsService.findByFatherCommentId(fatherCommentId, page, rows);
    }
}
