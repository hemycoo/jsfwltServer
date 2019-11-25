package com.jsfwlt.first.mapper;

import com.jsfwlt.first.po.TopicDetail;

public interface TopicDetailMapper {
    int deleteByPrimaryKey(String topicChildrenId);

    int insert(TopicDetail record);

    int insertSelective(TopicDetail record);

    TopicDetail selectByPrimaryKey(String topicChildrenId);

    int updateByPrimaryKeySelective(TopicDetail record);

    int updateByPrimaryKey(TopicDetail record);
}