package com.jsfwlt.first.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    Test selectByTid(int id);

}
