package com.csvideo.dao;

import com.csvideo.pojo.Videos;
import com.csvideo.pojo.VideosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideosMapper {
    int countByExample(VideosExample example);

    int deleteByExample(VideosExample example);

    int insert(Videos record);

    int insertSelective(Videos record);

    List<Videos> selectByExampleWithBLOBs(VideosExample example);

    List<Videos> selectByExample(VideosExample example);

    int updateByExampleSelective(@Param("record") Videos record, @Param("example") VideosExample example);

    int updateByExampleWithBLOBs(@Param("record") Videos record, @Param("example") VideosExample example);

    int updateByExample(@Param("record") Videos record, @Param("example") VideosExample example);
    String findUserId(String videosId);
}