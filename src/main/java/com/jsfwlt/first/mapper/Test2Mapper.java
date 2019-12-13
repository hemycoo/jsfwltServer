package com.jsfwlt.first.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface Test2Mapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Test2 record);

    int insertSelective(Test2 record);

    Test2 selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Test2 record);

    int updateByPrimaryKey(Test2 record);
}