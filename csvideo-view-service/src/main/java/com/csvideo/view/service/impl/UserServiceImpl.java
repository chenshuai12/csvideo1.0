package com.csvideo.view.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csvideo.dao.UserMapper;
import com.csvideo.entity.PageResult;
import com.csvideo.pojo.User;
import com.csvideo.pojo.UserExample;
import com.csvideo.view.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.csvideo.pojo.UserExample.Criteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Created by asus on 2019/3/15.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    /**
     * 用户注册
     * @param user
     */
    @Override
    public void add(User user) {
        String idCard = user.getIdCard();
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdCardEqualTo(idCard);
        if (userMapper.selectByExample(example) == null){
            String uuid = UUID.randomUUID().toString();
            user.setUserId(uuid);
            userMapper.insert(user);
        }
    }

    public User login(User user){
        String idCard = user.getIdCard();
        String password = user.getPassword();
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andIdCardEqualTo(idCard);
        criteria.andPasswordEqualTo(password);
        return (User)userMapper.selectByExample(example);
    }

    /**
     * 修改用户
     * @param user
     */
    @Override
    public void update(User user) {
        String userId = user.getUserId();
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        userMapper.updateByExampleSelective(user,example);
    }

    @Override
    public void delate(User user) {

    }

    /**
     * 查找用户信息
     * @param userId
     * @return
     */
    @Override
    public List<User> findOne(String userId) {
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        System.out.println("userServiceImpl:"+ userId);
        System.out.println("userServiceImpl:"+ userMapper.selectByExample(example));
        return userMapper.selectByExample(example);
    }

    /**
     * 查找所有用户
     * @return
     */
    @Override
    public List<User> findAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize,String userStatu) {
        PageHelper.startPage(pageNum,pageSize);  //分页
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserStatuEqualTo(userStatu);
        Page<User> page = (Page<User>) userMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }



    /**
     * 增加粉丝数
     * @param userId
     */
    @Override
    public void addFans(String userId) {

    }


    @Override
    public void descFans(String userId) {

    }

    @Override
    public void addFollow(String userId) {

    }

    @Override
    public void descFollow(String userId) {

    }
}
