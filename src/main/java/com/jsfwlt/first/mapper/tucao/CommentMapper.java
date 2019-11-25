package com.jsfwlt.first.mapper.tucao;

import com.jsfwlt.first.po.tucao.CommentPo;

public interface CommentMapper {
    int deleteByPrimaryKey(String commentId);

    int insert(CommentPo record);

    int insertSelective(CommentPo record);

    CommentPo selectByPrimaryKey(String commentId);

    int updateByPrimaryKeySelective(CommentPo record);

    int updateByPrimaryKey(CommentPo record);
}