package com.jsfwlt.first.service.tucao;

import com.jsfwlt.first.dto.tucao.CommentReplyListDto;
import com.jsfwlt.first.dto.tucao.ReplyDto;
import com.jsfwlt.first.mapper.tucao.CommentPoMapper;
import com.jsfwlt.first.mapper.tucao.ReplyPoMapper;
import com.jsfwlt.first.po.tucao.CommentPo;
import com.jsfwlt.first.po.tucao.ReplyPo;
import com.jsfwlt.first.utils.TimeUtils;
import com.jsfwlt.first.vo.tucao.CommentReplyListVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TopicDetailService {

    @Autowired(required = false)
    private CommentPoMapper commentPoMapper;

    @Autowired(required = false)
    private ReplyPoMapper replyPoMapper;

    public CommentReplyListVo selectCommentAndReplyByTopicChildrenId(String topicChildrenId) {
        List<CommentPo> commentPoList = commentPoMapper.selectCommentByTopicChildrenId(topicChildrenId);
        CommentReplyListVo commentReplyListVo = new CommentReplyListVo();
        for (CommentPo commentPo : commentPoList) {

            CommentReplyListDto commentReplyListDto = new CommentReplyListDto();
            BeanUtils.copyProperties(commentPo,commentReplyListDto);
            commentReplyListDto.setCommentTime(TimeUtils.date2String(commentPo.getCommentTime()));

            List<ReplyPo> replyPoList = replyPoMapper.selectByCommentId(commentPo.getCommentId());

            List<ReplyDto> replyDtos = new ArrayList<>();
            for (ReplyPo replyPo : replyPoList) {
                ReplyDto replyDto = new ReplyDto();
                BeanUtils.copyProperties(replyPo,replyDto);
                replyDto.setReplyTime(TimeUtils.date2String(replyPo.getReplyTime()));
                replyDtos.add(replyDto);
            }
            commentReplyListDto.getReplyList().addAll(replyDtos);

            commentReplyListVo.getCommentReplyData().add(commentReplyListDto);
        }
        return commentReplyListVo;
    }
}
