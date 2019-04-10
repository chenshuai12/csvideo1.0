package com.csvideo.dao;

import com.csvideo.pojo.UserLikeMovie;
import com.csvideo.pojo.UserLikeMovieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLikeMovieMapper {
    int countByExample(UserLikeMovieExample example);

    int deleteByExample(UserLikeMovieExample example);

    int insert(UserLikeMovie record);

    int insertSelective(UserLikeMovie record);

    List<UserLikeMovie> selectByExample(UserLikeMovieExample example);

    int updateByExampleSelective(@Param("record") UserLikeMovie record, @Param("example") UserLikeMovieExample example);

    int updateByExample(@Param("record") UserLikeMovie record, @Param("example") UserLikeMovieExample example);
}