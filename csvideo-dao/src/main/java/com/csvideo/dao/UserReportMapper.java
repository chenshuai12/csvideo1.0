package com.csvideo.dao;

import com.csvideo.pojo.UserReport;
import com.csvideo.pojo.UserReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserReportMapper {
    int countByExample(UserReportExample example);

    int deleteByExample(UserReportExample example);

    int insert(UserReport record);

    int insertSelective(UserReport record);

    List<UserReport> selectByExampleWithBLOBs(UserReportExample example);

    List<UserReport> selectByExample(UserReportExample example);

    int updateByExampleSelective(@Param("record") UserReport record, @Param("example") UserReportExample example);

    int updateByExampleWithBLOBs(@Param("record") UserReport record, @Param("example") UserReportExample example);

    int updateByExample(@Param("record") UserReport record, @Param("example") UserReportExample example);
}