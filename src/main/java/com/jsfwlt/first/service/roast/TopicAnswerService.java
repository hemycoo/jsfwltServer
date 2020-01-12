package com.jsfwlt.first.service.roast;

import com.jsfwlt.first.dto.roast.CommentReplyListDto;
import com.jsfwlt.first.dto.roast.ReplyDto;
import com.jsfwlt.first.mapper.roast.CommentReplyPoMapper;
import com.jsfwlt.first.mapper.roast.TopicAnswerCommentPoMapper;
import com.jsfwlt.first.mapper.roast.TopicAnswerPoMapper;
import com.jsfwlt.first.po.roast.CommentReplyPo;
import com.jsfwlt.first.po.roast.TopicAnswerCommentPo;
import com.jsfwlt.first.po.roast.TopicAnswerPo;
import com.jsfwlt.first.utils.TimeUtils;
import com.jsfwlt.first.vo.roast.AnswerInsertReq;
import com.jsfwlt.first.vo.roast.CommentReplyListResp;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TopicAnswerService {



    @Autowired
    private TopicAnswerCommentPoMapper topicAnswerCommentPoMapper;

    @Autowired
    private CommentReplyPoMapper commentReplyPoMapper;

    @Autowired
    private TopicAnswerPoMapper topicAnswerPoMapper;

    public CommentReplyListResp selectCommentAndReplyByTopicAnswerId(Integer topicAnswerId) {
        List<TopicAnswerCommentPo> commentPoList = topicAnswerCommentPoMapper.selectCommentByTopicAnswerId(topicAnswerId);
        CommentReplyListResp commentReplyListResp = new CommentReplyListResp();
        for (TopicAnswerCommentPo topicAnswerCommentPo : commentPoList) {

            CommentReplyListDto commentReplyListDto = new CommentReplyListDto();
            BeanUtils.copyProperties(topicAnswerCommentPo,commentReplyListDto);
            commentReplyListDto.setCreateTime(TimeUtils.date2String(topicAnswerCommentPo.getCreateTime()));
            commentReplyListDto.setModifyTime(TimeUtils.date2String(topicAnswerCommentPo.getModifyTime()));

            List<CommentReplyPo> replyPoList = commentReplyPoMapper.selectByCommentId(topicAnswerCommentPo.getCommentId());


            List<ReplyDto> replyDtos = new ArrayList<>();
            for (CommentReplyPo replyPo : replyPoList) {
                ReplyDto replyDto = new ReplyDto();
                BeanUtils.copyProperties(replyPo,replyDto);
                replyDto.setCreateTime(TimeUtils.date2String(replyPo.getCreateTime()));
                replyDto.setModifyTime(TimeUtils.date2String(replyPo.getModifyTime()));
                replyDtos.add(replyDto);
            }
            commentReplyListDto.getReplyList().addAll(replyDtos);

            commentReplyListResp.getCommentReplyData().add(commentReplyListDto);
        }
        return commentReplyListResp;
    }

    /**todo 由于用户名及昵称未传递，暂时未做保存，随机生成*/
    public void insertAnswer(AnswerInsertReq answerData){
        TopicAnswerPo topicAnswerPo = new TopicAnswerPo();
        Date date = new Date();
        topicAnswerPo.setTopicId(answerData.getTopicId());
        topicAnswerPo.setContent(answerData.getContent());
        topicAnswerPo.setCreateTime(date);
        topicAnswerPo.setModifyTime(date);
        topicAnswerPo.setLikeNumber(0);
        topicAnswerPo.setDislikeNumber(0);
        topicAnswerPo.setLogicDelete(true);
        topicAnswerPo.setUserId(1);
        topicAnswerPo.setUserNickname("insetAnswer");

        topicAnswerPoMapper.insertSelective(topicAnswerPo);
    }
}
