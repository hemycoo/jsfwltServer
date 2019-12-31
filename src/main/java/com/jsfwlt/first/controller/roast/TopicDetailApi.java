package com.jsfwlt.first.controller.roast;

import com.jsfwlt.first.controller.BaseApi;
import com.jsfwlt.first.exception.SelfException;
import com.jsfwlt.first.mapper.roast.TopicDetailMapper;
import com.jsfwlt.first.po.roast.TopicDetailPo;
import com.jsfwlt.first.service.tucao.TopicDetailService;
import com.jsfwlt.first.vo.tucao.CommentReplyListVo;
import com.jsfwlt.first.vo.tucao.TopicDetailListVo;
import com.jsfwlt.first.dto.roast.TopicDetailDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.jsfwlt.first.utils.TimeUtils.date2String;


@RestController
public class TopicDetailApi extends BaseApi {

    @Autowired(required = false)
    private TopicDetailMapper topicDetailMapper;

    @Autowired
    private TopicDetailService topicDetailService;

    private int queryNum = 0; //测试使用

    @RequestMapping("/tucao/topic/detail/query/{topicId}")
    public TopicDetailListVo queryTopicDetail(@PathVariable("topicId") String req) throws Exception {
        System.out.println("req  : " + req);
        TopicDetailListVo topicDetailListVo = new TopicDetailListVo();
        List<TopicDetailPo> topicDetailList = topicDetailMapper.selectByTopicId(req);
        if (topicDetailList.size() == 0 || topicDetailList.isEmpty()){
            throw new SelfException("000","sorry, query no data");
        }
        System.out.println(date2String(topicDetailList.get(0).getCreationTime()));
        for (TopicDetailPo list : topicDetailList){
            TopicDetailDto topicDetailDto = new TopicDetailDto();
            BeanUtils.copyProperties(list,topicDetailDto);
            topicDetailDto.setCreationTime(date2String( list.getCreationTime()));
            topicDetailDto.setModificationTime(date2String(list.getModificationTime()));
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
