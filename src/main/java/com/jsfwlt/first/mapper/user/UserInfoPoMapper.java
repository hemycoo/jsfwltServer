package com.jsfwlt.first.mapper.user;

import com.jsfwlt.first.po.user.UserInfoPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoPoMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfoPo record);

    int insertSelective(UserInfoPo record);

    UserInfoPo selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(UserInfoPo record);

    int updateByPrimaryKey(UserInfoPo record);

    UserInfoPo selectByUserName(String userName);
}