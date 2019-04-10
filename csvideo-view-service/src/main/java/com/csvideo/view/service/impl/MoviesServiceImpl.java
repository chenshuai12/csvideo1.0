package com.csvideo.view.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.csvideo.dao.MoviesMapper;
import com.csvideo.entity.PageResult;
import com.csvideo.pojo.Movies;
import com.csvideo.pojo.MoviesExample;
import com.csvideo.pojo.VideosExample;
import com.csvideo.view.service.MoviesService;

import java.rmi.MarshalledObject;
import java.util.List;
import java.util.UUID;
import com.csvideo.pojo.MoviesExample.Criteria;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.zookeeper.data.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by asus on 2019/3/15.
 */
@Service
@Transactional
public class MoviesServiceImpl implements MoviesService {

    @Autowired
    private MoviesMapper moviesMapper;

    /**
     * 上传电影
     * @param movies
     */
    @Override
    public void add(Movies movies) {
        String moviesId = UUID.randomUUID().toString();
        movies.setMoviesId(moviesId);
        moviesMapper.insert(movies);
    }

    /**
     * 修改电影，封禁审核等
     * @param movies
     */
    @Override
    public void update(Movies movies) {
        MoviesExample example = new MoviesExample();
        Criteria criteria = example.createCriteria();
        criteria.andMoviesIdEqualTo(movies.getMoviesId());
        moviesMapper.updateByExampleSelective(movies,example);
    }

    /**
     * 查找所有电影
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(int pageNum, int pageSize,String moviesStatu) {
        PageHelper.startPage(pageNum,pageSize);
        MoviesExample example = new MoviesExample();
        Criteria criteria = example.createCriteria();
        criteria.andMoviesStatuEqualTo(moviesStatu);
        Page<Movies> page = (Page<Movies>) moviesMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }

    /**
     * 根据id查找电影
     * @param moviesId
     * @return
     */
    @Override
    public List<Movies> findOne(String moviesId) {
        MoviesExample example = new MoviesExample();
        Criteria criteria = example.createCriteria();
        criteria.andMoviesIdEqualTo(moviesId);
        return moviesMapper.selectByExample(example);
    }

    /**
     * 条件查找电影
     * @param movies
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public PageResult findPage(Movies movies, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        String categoryId =  movies.getCategoryId();
        String userId = movies.getUserId();
        MoviesExample example = new MoviesExample();
        Criteria criteria = example.createCriteria();
        if (userId != null && userId.length() > 0 ){
            criteria.andUserIdEqualTo(userId);
        }if (categoryId != null && categoryId.length() > 0){
            criteria.andCategoryIdEqualTo(categoryId);
        }if (movies.getMoviesStatu() != null && movies.getMoviesStatu().length() > 0){
            criteria.andMoviesStatuEqualTo(movies.getMoviesStatu());
        }
        Page<Movies> page = (Page<Movies>) moviesMapper.selectByExample(example);
        return new PageResult(page.getTotal(),page.getResult());
    }
    public List<Movies> findList(Movies movies){
        String userId = movies.getUserId();
        MoviesExample example = new MoviesExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);
        return moviesMapper.selectByExample(example);
    }

    @Override
    public void delete(String moviesId) {
        MoviesExample example = new MoviesExample();
        Criteria criteria = example.createCriteria();
        criteria.andMoviesIdEqualTo(moviesId);
        moviesMapper.deleteByExample(example);
    }
}
