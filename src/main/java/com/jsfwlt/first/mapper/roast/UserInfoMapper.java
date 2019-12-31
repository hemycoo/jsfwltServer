package com.jsfwlt.first.mapper.roast;

import com.jsfwlt.first.po.roast.UserInfoPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(UserInfoPo record);

    int insertSelective(UserInfoPo record);

    UserInfoPo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(UserInfoPo record);

    int updateByPrimaryKey(UserInfoPo record);

    UserInfoPo selectByUserNickname(String userNickname);

}