package com.jsfwlt.first.mapper.roast;

import com.jsfwlt.first.po.roast.CommentPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentPoMapper {
    int deleteByPrimaryKey(String commentId);

    int insert(CommentPo record);

    int insertSelective(CommentPo record);

    CommentPo selectByPrimaryKey(String commentId);

    int updateByPrimaryKeySelective(CommentPo record);

    int updateByPrimaryKey(CommentPo record);

    List<CommentPo> selectCommentByTopicChildrenId(String topicChildrenId);
}