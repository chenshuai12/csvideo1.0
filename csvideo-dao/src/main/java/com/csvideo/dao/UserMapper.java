package com.csvideo.dao;

import com.csvideo.pojo.User;
import com.csvideo.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
    void addFans(String userId);
    void addFolow(String userId);
    void descFans(String  userId);
    void descFolow(String userId);
    void addPraise(String userId);
    List<User> findFans(String userId);
    List<User> findFollow(String userId);
}