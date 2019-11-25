package com.jsfwlt.first.mapper.tucao;

import com.jsfwlt.first.po.tucao.TucaoTopicPo;

public interface TucaoTopicMapper {
    int deleteByPrimaryKey(String topicId);

    int insert(TucaoTopicPo record);

    int insertSelective(TucaoTopicPo record);

    TucaoTopicPo selectByPrimaryKey(String topicId);

    int updateByPrimaryKeySelective(TucaoTopicPo record);

    int updateByPrimaryKey(TucaoTopicPo record);
}