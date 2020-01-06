package com.jsfwlt.first.mapper.roast;

import com.jsfwlt.first.po.roast.LoginTokenPo;

public interface LoginTokenPoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginTokenPo record);

    int insertSelective(LoginTokenPo record);

    LoginTokenPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginTokenPo record);

    int updateByPrimaryKey(LoginTokenPo record);
}