package com.csvideo.view.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csvideo.dao.VideosReportMapper;
import com.csvideo.entity.PageResult;
import com.csvideo.pojo.UserReport;
import com.csvideo.pojo.VideosReport;
import com.csvideo.pojo.VideosReportExample;
import com.csvideo.view.service.VideosReportService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.csvideo.pojo.VideosReportExample.Criteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * Created by asus on 2019/3/15.
 */
@Service
@Transactional
public class VideosReportServiceImpl implements VideosReportService{
    @Autowired
    private VideosReportMapper videosReportMapper;

    @Override
    public void add(VideosReport videosrRport) {
        videosrRport.setDate(new Date().toString());
        videosrRport.setVideoReportId(UUID.randomUUID().toString());
        videosReportMapper.insert(videosrRport);
    }

    @Override
    public PageResult find(int pageNum,int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        Page<VideosReport> page = (Page<VideosReport>) videosReportMapper.selectByExample(null);
        return new PageResult(page.getTotal(),page.getResult());
    }

    public void delate(VideosReport videosReport){
        String videoReportId = videosReport.getVideoReportId();
        VideosReportExample example = new VideosReportExample();
        Criteria criteria = example.createCriteria();
        criteria.andVideoReportIdEqualTo(videoReportId);
        videosReportMapper.deleteByExample(example);
    }

}
