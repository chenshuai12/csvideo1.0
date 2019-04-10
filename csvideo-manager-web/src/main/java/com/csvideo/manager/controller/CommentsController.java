package com.csvideo.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.csvideo.entity.PageResult;
import com.csvideo.entity.Result;
import com.csvideo.pojo.Comments;
import com.csvideo.pojo.User;
import com.csvideo.view.service.CommentsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by asus on 2019/3/19.
 */
@RestController
@RequestMapping("/comment")
public class CommentsController {
    @Reference
    private CommentsService commentsService;
    /**
     * 根据用户id查询所有评论
     */
    @RequestMapping("/getByUserId")
    public List<Comments> getByUserId( String userId){
        User user = new User();
        user.setUserId(userId);
        return commentsService.findByUserId(user);
    }
    @RequestMapping("/getByUserIdWithoutPage")
    public List<Comments> getByUserIdWithoutPage(String userId){
        return commentsService.getByUserIdWithoutPage(userId);
    }

    /**
     * 删除评论
     */
    @RequestMapping(value = "/delete")
    public Result delete( String commentId){
        try {
            commentsService.delate(commentId);
            return new Result(true,"删除成功");
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"删除失败");
        }
    }
}
