package com.jsfwlt.first.api.roast;

import com.jsfwlt.first.api.BaseApi;
import com.jsfwlt.first.exception.SelfException;
import com.jsfwlt.first.mapper.roast.TopicAnswerPoMapper;
import com.jsfwlt.first.po.roast.TopicAnswerPo;
import com.jsfwlt.first.service.roast.TopicAnswerService;
import com.jsfwlt.first.vo.roast.CommentReplyListResp;
import com.jsfwlt.first.vo.roast.TopicAnswerListResp;
import com.jsfwlt.first.dto.roast.TopicAnswerDto;
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
    private TopicAnswerService topicAnswerService;

    private int queryNum = 0; //测试使用

    @GetMapping("/roast/topic/answer/query/{topicId}")
    public TopicAnswerListResp queryTopicAnswer(@PathVariable("topicId") int req){
        System.out.println("req  : " + req);
        TopicAnswerListResp topicAnswerListResp = new TopicAnswerListResp();
        List<TopicAnswerPo> topicAnswerList = topicAnswerPoMapper.selectByTopicId(req);
        if (topicAnswerList.size() == 0 || topicAnswerList.isEmpty()){
            throw new SelfException("000","sorry, query no data, your topicId is "+ req);
        }
        System.out.println(date2String(topicAnswerList.get(0).getCreateTime()));
        for (TopicAnswerPo list : topicAnswerList){
            TopicAnswerDto topicAnswerDto = new TopicAnswerDto();
            BeanUtils.copyProperties(list, topicAnswerDto);
            topicAnswerDto.setCreateTime(date2String( list.getCreateTime()));
            topicAnswerDto.setModifyTime(date2String(list.getModifyTime()));
            topicAnswerListResp.getTopicAnswerData().add(topicAnswerDto);
        }
        queryNum++;
        System.out.println("query success  " + queryNum);
        return topicAnswerListResp;
    }

    @GetMapping("/roast/topic/answer/querycomment/{topicAnswerId}")
    public CommentReplyListResp queryCommentReply(@PathVariable int topicAnswerId){
        CommentReplyListResp commentReplyListResp = topicAnswerService.selectCommentAndReplyByTopicAnswerId(topicAnswerId);
        System.out.println("comment success");
        return commentReplyListResp;
    }
    

}
