package com.jsfwlt.first.mapper.roast;

import com.jsfwlt.first.po.roast.TopicContentPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopicContentPoMapper {
    int deleteByPrimaryKey(Integer contentId);

    int insert(TopicContentPo record);

    int insertSelective(TopicContentPo record);

    TopicContentPo selectByPrimaryKey(Integer contentId);

    int updateByPrimaryKeySelective(TopicContentPo record);

    int updateByPrimaryKey(TopicContentPo record);
}