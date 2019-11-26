package com.jsfwlt.first.controller.tucao;

import com.jsfwlt.first.controller.BaseApi;
import com.jsfwlt.first.mapper.tucao.TopicDetailMapper;
import com.jsfwlt.first.vo.tucao.TopicDetailListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicDetailApi extends BaseApi {

    @Autowired(required = false)
    private TopicDetailMapper topicDetailMapper;

    @GetMapping("/tucao/topic/detail/query")
    public TopicDetailListVo queryTopicDetail(){
        TopicDetailListVo topicDetailPo = new TopicDetailListVo();
        topicDetailPo.setData(topicDetailMapper.selectByTopicId("topicId"));
        System.out.println("query success");
        return topicDetailPo;
    }
}
