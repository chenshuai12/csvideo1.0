package com.csvideo.dao;

import com.csvideo.pojo.MovieCategory;
import com.csvideo.pojo.MovieCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MovieCategoryMapper {
    int countByExample(MovieCategoryExample example);

    int deleteByExample(MovieCategoryExample example);

    int insert(MovieCategory record);

    int insertSelective(MovieCategory record);

    List<MovieCategory> selectByExample(MovieCategoryExample example);

    int updateByExampleSelective(@Param("record") MovieCategory record, @Param("example") MovieCategoryExample example);

    int updateByExample(@Param("record") MovieCategory record, @Param("example") MovieCategoryExample example);
}