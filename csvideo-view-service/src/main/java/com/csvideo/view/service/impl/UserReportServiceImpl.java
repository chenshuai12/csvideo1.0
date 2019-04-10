package com.csvideo.view.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csvideo.dao.UserReportMapper;
import com.csvideo.entity.PageResult;
import com.csvideo.pojo.UserReport;
import com.csvideo.pojo.UserReportExample;
import com.csvideo.view.service.UserReportService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.csvideo.pojo.UserReportExample.Criteria;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by asus on 2019/3/15.
 */
@Service
@Transactional
public class UserReportServiceImpl implements UserReportService {
    @Autowired
    private UserReportMapper userReportMapper;

    @Override
    public PageResult find(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<UserReport> page = (Page<UserReport>) userReportMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    @Override
    public void add(UserReport user_report) {
        user_report.setDate(new Date().toString());
        user_report.setUserReportId(UUID.randomUUID().toString());
        userReportMapper.insert(user_report);
    }
    public void delate(UserReport userReport){
        String userReportId = userReport.getUserReportId();
        UserReportExample example = new UserReportExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserReportIdEqualTo(userReportId);
        userReportMapper.deleteByExample(example);
    }
}
