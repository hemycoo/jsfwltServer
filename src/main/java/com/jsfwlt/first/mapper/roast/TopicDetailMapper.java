package com.jsfwlt.first.mapper.roast;

import com.jsfwlt.first.po.roast.TopicDetailPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TopicDetailMapper {
    int deleteByPrimaryKey(String topicChildrenId);

    int insert(TopicDetailPo record);

    int insertSelective(TopicDetailPo record);

    TopicDetailPo selectByPrimaryKey(String topicChildrenId);

    int updateByPrimaryKeySelective(TopicDetailPo record);

    int updateByPrimaryKey(TopicDetailPo record);

    List<TopicDetailPo> selectByTopicId(String topicId);
}