package com.jsfwlt.first.mapper.tucao;

import com.jsfwlt.first.po.tucao.ReplyPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyPoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_reply
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String replyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_reply
     *
     * @mbggenerated
     */
    int insert(ReplyPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_reply
     *
     * @mbggenerated
     */
    int insertSelective(ReplyPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_reply
     *
     * @mbggenerated
     */
    ReplyPo selectByPrimaryKey(String replyId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_reply
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(ReplyPo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_reply
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(ReplyPo record);
}