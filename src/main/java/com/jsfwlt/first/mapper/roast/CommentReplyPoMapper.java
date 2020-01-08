package com.jsfwlt.first.mapper.roast;

import com.jsfwlt.first.po.roast.CommentReplyPo;

import java.util.List;

public interface CommentReplyPoMapper {
    int deleteByPrimaryKey(Integer replyId);

    int insert(CommentReplyPo record);

    int insertSelective(CommentReplyPo record);

    CommentReplyPo selectByPrimaryKey(Integer replyId);

    int updateByPrimaryKeySelective(CommentReplyPo record);

    int updateByPrimaryKey(CommentReplyPo record);

    List<CommentReplyPo> selectByCommentId(Integer commentId);
}