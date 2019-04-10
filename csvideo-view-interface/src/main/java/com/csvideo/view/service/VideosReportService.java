package com.csvideo.view.service;

import com.csvideo.entity.PageResult;
import com.csvideo.pojo.VideosReport;

/**
 * Created by asus on 2019/3/15.
 */
public interface VideosReportService {
    /**
     * 举报视频
     */
    public void add(VideosReport videosReport);
    public PageResult find(int pageNum,int pageSize);
    public void delate(VideosReport videosReport);
}
