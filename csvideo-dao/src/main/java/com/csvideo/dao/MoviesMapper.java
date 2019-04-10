package com.csvideo.dao;

import com.csvideo.pojo.Movies;
import com.csvideo.pojo.MoviesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoviesMapper {
    int countByExample(MoviesExample example);

    int deleteByExample(MoviesExample example);

    int insert(Movies record);

    int insertSelective(Movies record);

    List<Movies> selectByExampleWithBLOBs(MoviesExample example);

    List<Movies> selectByExample(MoviesExample example);

    int updateByExampleSelective(@Param("record") Movies record, @Param("example") MoviesExample example);

    int updateByExampleWithBLOBs(@Param("record") Movies record, @Param("example") MoviesExample example);

    int updateByExample(@Param("record") Movies record, @Param("example") MoviesExample example);
    String findUserId(String moviesId);
}