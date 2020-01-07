package com.jsfwlt.first.mapper.roast;

import com.jsfwlt.first.po.roast.TopicAnswerCommentPo;

import java.util.List;

public interface TopicAnswerCommentPoMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(TopicAnswerCommentPo record);

    int insertSelective(TopicAnswerCommentPo record);

    TopicAnswerCommentPo selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(TopicAnswerCommentPo record);

    int updateByPrimaryKey(TopicAnswerCommentPo record);

    List<TopicAnswerCommentPo> selectCommentByTopicAnswerId(String topicAnswerId);
}