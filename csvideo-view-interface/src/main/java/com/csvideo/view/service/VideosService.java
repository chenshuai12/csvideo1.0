package com.csvideo.view.service;

import com.csvideo.entity.PageResult;
import com.csvideo.pojo.Videos;

import javax.print.DocFlavor;
import java.util.List;

/**
 * Created by asus on 2019/3/15.
 */
public interface VideosService {
    /**
     * 上传视频
     */
    public void add(Videos videos);

    /**
     * 封禁视频
     */
    public void update(Videos videos);

    /**
     * 查找所有视频
     */
    public PageResult findPage(int pageNum,int pageSize,String videosStatu);

    /**
     * 根据id查询实体
     */
    public List<Videos> findOne(String videosId);

    /**
     * 条件查询
     */
    public PageResult findPage(String useId,int pageNum,int pageSize,String videosStatu);
    public List<Videos> findList(String userId);
    /**
     * 删除视频
     */
    public void delete(String videosId);

}
