package com.jsfwlt.first.mapper.roast;

import com.jsfwlt.first.po.roast.ReplyPo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReplyPoMapper {
    int deleteByPrimaryKey(String replyId);

    int insert(ReplyPo record);

    int insertSelective(ReplyPo record);

    ReplyPo selectByPrimaryKey(String replyId);

    int updateByPrimaryKeySelective(ReplyPo record);

    int updateByPrimaryKey(ReplyPo record);

    List<ReplyPo> selectByCommentId(String commentId);
}