package com.jsfwlt.first.api.roast;

import com.jsfwlt.first.api.BaseApi;
import com.jsfwlt.first.exception.SelfException;
import com.jsfwlt.first.mapper.roast.TopicAnswerPoMapper;
import com.jsfwlt.first.po.roast.TopicAnswerPo;
import com.jsfwlt.first.service.roast.TopicDetailService;
import com.jsfwlt.first.vo.roast.CommentReplyListVo;
import com.jsfwlt.first.vo.roast.TopicDetailListResp;
import com.jsfwlt.first.dto.roast.TopicDetailDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jsfwlt.first.utils.TimeUtils.date2String;


@RestController
public class TopicAnswerApi extends BaseApi {

    @Autowired
    private TopicAnswerPoMapper topicAnswerPoMapper;

    @Autowired
    private TopicDetailService topicDetailService;

    private int queryNum = 0; //测试使用

    @RequestMapping("/tucao/topic/answer/query/{topicId}")
    public TopicDetailListResp queryTopicDetail(@PathVariable("topicId") String req) throws Exception {
        System.out.println("req  : " + req);
        TopicDetailListResp topicDetailListResp = new TopicDetailListResp();
        List<TopicAnswerPo> topicAnswerList = topicAnswerPoMapper.selectByTopicId(req);
        if (topicAnswerList.size() == 0 || topicAnswerList.isEmpty()){
            throw new SelfException("000","sorry, query no data, your topicId is "+ req);
        }
        System.out.println(date2String(topicAnswerList.get(0).getCreateTime()));
        for (TopicAnswerPo list : topicAnswerList){
            TopicDetailDto topicDetailDto = new TopicDetailDto();
            BeanUtils.copyProperties(list,topicDetailDto);
            topicDetailDto.setCreationTime(date2String( list.getCreateTime()));
            topicDetailDto.setModificationTime(date2String(list.getModifyTime()));
            topicDetailListResp.getTopicDetaildata().add(topicDetailDto);
        }
        queryNum++;
        System.out.println("query success" + queryNum);
        return topicDetailListResp;
    }

    @RequestMapping("/tucao/topic/detail/querycomment/{topicChildrenId}")
    public CommentReplyListVo queryCommentReply(@PathVariable String topicChildrenId){
        CommentReplyListVo commentReplyListVo = topicDetailService.selectCommentAndReplyByTopicChildrenId(topicChildrenId);
        System.out.println("comment success");
        return commentReplyListVo;
    }

}