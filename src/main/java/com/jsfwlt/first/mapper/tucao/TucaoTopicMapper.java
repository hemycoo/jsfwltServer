package com.jsfwlt.first.mapper.tucao;

import com.jsfwlt.first.po.tucao.TucaoTopicPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TucaoTopicMapper {
    int deleteByPrimaryKey(String topicId);

    int insert(TucaoTopicPo record);

    int insertSelective(TucaoTopicPo record);

    TucaoTopicPo selectByPrimaryKey(String topicId);

    int updateByPrimaryKeySelective(TucaoTopicPo record);

    int updateByPrimaryKey(TucaoTopicPo record);

    List<TucaoTopicPo> selectAllTucaoTopic();
}