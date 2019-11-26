package com.jsfwlt.first.mapper.tucao;

import com.jsfwlt.first.po.tucao.TopicDetailPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicDetailMapper {
    int deleteByPrimaryKey(String topicChildrenId);

    int insert(TopicDetailPo record);

    int insertSelective(TopicDetailPo record);

    TopicDetailPo selectByPrimaryKey(String topicChildrenId);

    int updateByPrimaryKeySelective(TopicDetailPo record);

    int updateByPrimaryKey(TopicDetailPo record);
}