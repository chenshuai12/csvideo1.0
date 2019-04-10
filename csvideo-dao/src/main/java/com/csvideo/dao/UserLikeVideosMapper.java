package com.csvideo.dao;

import com.csvideo.pojo.UserLikeVideos;
import com.csvideo.pojo.UserLikeVideosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserLikeVideosMapper {
    int countByExample(UserLikeVideosExample example);

    int deleteByExample(UserLikeVideosExample example);

    int insert(UserLikeVideos record);

    int insertSelective(UserLikeVideos record);

    List<UserLikeVideos> selectByExample(UserLikeVideosExample example);

    int updateByExampleSelective(@Param("record") UserLikeVideos record, @Param("example") UserLikeVideosExample example);

    int updateByExample(@Param("record") UserLikeVideos record, @Param("example") UserLikeVideosExample example);
}