package com.jsfwlt.first.mapper;


import com.jsfwlt.first.po.Test;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestMapper {

    Test selectByTid(int id);

}
