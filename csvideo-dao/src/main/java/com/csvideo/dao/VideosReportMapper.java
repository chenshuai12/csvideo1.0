package com.csvideo.dao;

import com.csvideo.pojo.VideosReport;
import com.csvideo.pojo.VideosReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VideosReportMapper {
    int countByExample(VideosReportExample example);

    int deleteByExample(VideosReportExample example);

    int insert(VideosReport record);

    int insertSelective(VideosReport record);

    List<VideosReport> selectByExampleWithBLOBs(VideosReportExample example);

    List<VideosReport> selectByExample(VideosReportExample example);

    int updateByExampleSelective(@Param("record") VideosReport record, @Param("example") VideosReportExample example);

    int updateByExampleWithBLOBs(@Param("record") VideosReport record, @Param("example") VideosReportExample example);

    int updateByExample(@Param("record") VideosReport record, @Param("example") VideosReportExample example);
}