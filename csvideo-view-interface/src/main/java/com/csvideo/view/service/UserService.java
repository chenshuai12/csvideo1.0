package com.csvideo.view.service;


import com.csvideo.entity.PageResult;
import com.csvideo.pojo.User;

import java.util.List;

/**
 * 用户接口
 * Created by asus on 2019/3/15.
 */
public interface UserService {
    /**
     * 注册用户
     */
    public void add(User user);

    /**
     * 用户自己修改用户信息
     *
     */
    public void update(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 封禁用户封禁用户 0：正常；1：禁止用户
     */

    public void delate(User user);

    /**
     * 查看用户信息
     */
    public List<User> findOne(String userId);

    /**
     * 分页查看所有用户信息
     */
    public List<User> findAll();

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(int pageNum,int pageSize,String userStatu);


    /**
     * 添加粉丝数
     * @param userId
     */
    public void addFans(String userId);
    public void descFans(String userId);

    /**
     * 添加关注数
     * @param userId
     */
    public void addFollow(String userId);
    public void descFollow(String userId);
}
