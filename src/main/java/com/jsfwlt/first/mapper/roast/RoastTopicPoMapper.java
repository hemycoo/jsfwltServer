package com.jsfwlt.first.mapper.roast;

import com.jsfwlt.first.po.roast.RoastTopicPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoastTopicPoMapper {
    int deleteByPrimaryKey(Integer topicId);

    int insert(RoastTopicPo record);

    int insertSelective(RoastTopicPo record);

    RoastTopicPo selectByPrimaryKey(Integer topicId);

    int updateByPrimaryKeySelective(RoastTopicPo record);

    int updateByPrimaryKey(RoastTopicPo record);

    List<RoastTopicPo> selectAllRoastTopic();
}