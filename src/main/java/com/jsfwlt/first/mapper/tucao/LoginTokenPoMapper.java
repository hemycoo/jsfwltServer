package com.jsfwlt.first.mapper.tucao;

import com.jsfwlt.first.po.tucao.LoginTokenPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginTokenPoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(LoginTokenPo record);

    int insertSelective(LoginTokenPo record);

    LoginTokenPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(LoginTokenPo record);

    int updateByPrimaryKey(LoginTokenPo record);

    LoginTokenPo selectByToken(String token);
}