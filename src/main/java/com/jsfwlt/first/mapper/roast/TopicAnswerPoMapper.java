package com.jsfwlt.first.mapper.roast;

import com.jsfwlt.first.po.roast.TopicAnswerPo;

import java.util.List;

public interface TopicAnswerPoMapper {
    int deleteByPrimaryKey(Integer topicAnswerId);

    int insert(TopicAnswerPo record);

    int insertSelective(TopicAnswerPo record);

    TopicAnswerPo selectByPrimaryKey(Integer topicAnswerId);

    int updateByPrimaryKeySelective(TopicAnswerPo record);

    int updateByPrimaryKey(TopicAnswerPo record);

    List<TopicAnswerPo> selectByTopicId(String topicId);
}