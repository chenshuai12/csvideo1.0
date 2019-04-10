package com.csvideo.view.service;

import com.csvideo.entity.PageResult;
import com.csvideo.pojo.UserReport;

/**
 * Created by asus on 2019/3/15.
 */
public interface UserReportService {
    /**
     * 举报用户
     */
    public PageResult find(int pageNum, int pageSize);
    public void add(UserReport userReport);
    public void delate(UserReport userReport);
}
