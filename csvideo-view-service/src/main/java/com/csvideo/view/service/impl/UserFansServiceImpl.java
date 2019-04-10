package com.csvideo.view.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csvideo.dao.UserFansMapper;
import com.csvideo.dao.UserMapper;
import com.csvideo.entity.PageResult;
import com.csvideo.pojo.User;
import com.csvideo.pojo.UserExample;
import com.csvideo.pojo.UserFans;
import com.csvideo.pojo.UserFansExample;
import com.csvideo.view.service.UserFansService;
import com.csvideo.pojo.UserFansExample.Criteria;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by asus on 2019/3/15.
 */
@Service
@Transactional
public class UserFansServiceImpl implements UserFansService {
    @Autowired
    private UserFansMapper userFansMapper;
    @Autowired
    private UserMapper userMapper;

    /**
     * 根据用户自己查找所有粉丝
     * @param user
     * @return
     */
    @Override
    public PageResult findByUserId(User user,int pageNum,int pageSize) {
        String userId = user.getUserId();
        PageHelper.startPage(pageNum,pageSize);
        Page<User> page = (Page<User>) userMapper.findFans(userId);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 查找所有关注的人
     * @param user
     * @return
     */
    @Override
    public PageResult findByFansId(User user,int pageNum,int pageSize) {
       String userId = user.getUserId();
       PageHelper.startPage(pageNum,pageSize);
       Page<User> page = (Page<User>) userMapper.findFollow(userId);
       return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 添加用户关注
     * @param userId
     * @param fansId
     */
    @Override
    public void add(String userId, String fansId) {
//        保存关系
        UserFans userFans = new UserFans();
        userFans.setUserFansId(UUID.randomUUID().toString());
        userFans.setUserId(userId);
        userFans.setFansId(fansId);
        userFansMapper.insert(userFans);
//      粉丝加1

        userMapper.addFans(userId);
//      关注加1
        userMapper.addFolow(fansId);

    }

    /**
     * 删除关注
     * @param userId
     * @param fansId
     */
    @Override
    public void delate(String userId, String fansId) {
        UserFansExample example = new UserFansExample();
        Criteria criteria = example.createCriteria();
        criteria.andFansIdEqualTo(fansId);
        criteria.andUserIdEqualTo(userId);
        userFansMapper.deleteByExample(example);

        userMapper.descFans(userId);

        userMapper.descFolow(fansId);
    }
}
