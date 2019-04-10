package com.csvideo.view.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csvideo.dao.VideosMapper;
import com.csvideo.entity.PageResult;
import com.csvideo.pojo.MoviesExample;
import com.csvideo.pojo.Videos;
import com.csvideo.pojo.VideosExample;
import com.csvideo.view.service.VideosService;

import java.util.List;
import java.util.UUID;
import com.csvideo.pojo.VideosExample.Criteria;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by asus on 2019/3/15.
 */
@Service
@Transactional
public class VideosServiceImpl implements VideosService {
    @Autowired
    private VideosMapper videosMapper;

    @Override
    public void add(Videos videos) {
        String videosId = UUID.randomUUID().toString();
        videos.setVideosId(videosId);
        videosMapper.insert(videos);
    }

    /**
     * 修改视频，封禁审核等
     * @param videos
     */
    @Override
    public void update(Videos videos) {
        VideosExample example = new VideosExample();
        Criteria criteria = example.createCriteria();
        criteria.andVideosIdEqualTo(videos.getVideosId());
        videosMapper.updateByExample(videos,example);
    }

    /**
     * 查找所有视频
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize,String videosStatu) {
        PageHelper.startPage(pageNum,pageSize);
        VideosExample example = new VideosExample();
        Criteria criteria = example.createCriteria();
        criteria.andVideosStatuEqualTo(videosStatu);
        Page<Videos> page = (Page<Videos>) videosMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 根据id查找短视频
     * @param videosId
     * @return
     */
    @Override
    public List<Videos> findOne(String videosId) {
        VideosExample example = new VideosExample();
        Criteria criteria = example.createCriteria();
        criteria.andVideosIdEqualTo(videosId);
        return  videosMapper.selectByExample(example);
    }

    /**
     * 条件查找短视频
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(String userId, int pageNum, int pageSize,String videosStatu) {
        PageHelper.startPage(pageNum,pageSize);
        VideosExample example = new VideosExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        criteria.andVideosStatuEqualTo(videosStatu);
        Page<Videos> page = (Page<Videos>) videosMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }
    public List<Videos> findList(String userId){
        VideosExample example = new VideosExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return videosMapper.selectByExample(example);
    }

    @Override
    public void delete(String videosId) {
        VideosExample example = new VideosExample();
        Criteria criteria = example.createCriteria();
        criteria.andVideosIdEqualTo(videosId);
        videosMapper.deleteByExample(example);
    }

}
