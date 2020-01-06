package com.jsfwlt.first.controller.roast;

import com.jsfwlt.first.controller.BaseApi;
import com.jsfwlt.first.exception.SelfException;
import com.jsfwlt.first.mapper.roast.TopicAnswerPoMapper;
import com.jsfwlt.first.mapper.roast.TopicDetailMapper;
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
public class TopicDetailApi extends BaseApi {

    //todo 待删除
    @Autowired(required = false)
    private TopicDetailMapper topicDetailMapper;

    private TopicAnswerPoMapper topicAnswerPoMapper;

    @Autowired
    private TopicDetailService topicDetailService;

    private int queryNum = 0; //测试使用

    @RequestMapping("/tucao/topic/detail/query/{topicId}")
    public TopicDetailListResp queryTopicDetail(@PathVariable("topicId") String req) throws Exception {
        System.out.println("req  : " + req);
        TopicDetailListResp topicDetailListVo = new TopicDetailListResp();
        List<TopicAnswerPo> topicDetailList = topicAnswerPoMapper.selectByTopicId(req);
        if (topicDetailList.size() == 0 || topicDetailList.isEmpty()){
            throw new SelfException("000","sorry, query no data");
        }
        System.out.println(date2String(topicDetailList.get(0).getCreateTime()));
        for (TopicAnswerPo list : topicDetailList){
            TopicDetailDto topicDetailDto = new TopicDetailDto();
            BeanUtils.copyProperties(list,topicDetailDto);
            topicDetailDto.setCreationTime(date2String( list.getCreateTime()));
            topicDetailDto.setModificationTime(date2String(list.getModifyTime()));
            topicDetailListVo.getTopicDetaildata().add(topicDetailDto);
        }
        queryNum++;
        System.out.println("query success" + queryNum);
        return topicDetailListVo;
    }

    @RequestMapping("/tucao/topic/detail/querycomment/{topicChildrenId}")
    public CommentReplyListVo queryCommentReply(@PathVariable String topicChildrenId){
        CommentReplyListVo commentReplyListVo = topicDetailService.selectCommentAndReplyByTopicChildrenId(topicChildrenId);
        System.out.println("comment success");
        return commentReplyListVo;
    }

}
