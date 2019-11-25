package com.jsfwlt.first.mapper;

import com.jsfwlt.first.po.TucaoTopic;

public interface TucaoTopicMapper {
    int deleteByPrimaryKey(String topicId);

    int insert(TucaoTopic record);

    int insertSelective(TucaoTopic record);

    TucaoTopic selectByPrimaryKey(String topicId);

    int updateByPrimaryKeySelective(TucaoTopic record);

    int updateByPrimaryKey(TucaoTopic record);
}