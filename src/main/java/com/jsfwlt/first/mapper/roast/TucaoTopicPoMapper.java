package com.jsfwlt.first.mapper.roast;

import com.jsfwlt.first.po.roast.TucaoTopicPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TucaoTopicPoMapper {
    int deleteByPrimaryKey(String topicId);

    int insert(TucaoTopicPo record);

    int insertSelective(TucaoTopicPo record);

    TucaoTopicPo selectByPrimaryKey(String topicId);

    int updateByPrimaryKeySelective(TucaoTopicPo record);

    int updateByPrimaryKey(TucaoTopicPo record);

    List<TucaoTopicPo> selectAllTucaoTopic();
}