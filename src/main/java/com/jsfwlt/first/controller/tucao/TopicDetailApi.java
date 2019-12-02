package com.jsfwlt.first.controller.tucao;

import com.jsfwlt.first.controller.BaseApi;
import com.jsfwlt.first.mapper.tucao.TopicDetailMapper;
import com.jsfwlt.first.po.tucao.TopicDetailPo;
import com.jsfwlt.first.vo.tucao.TopicDetailListVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class TopicDetailApi extends BaseApi {

    @Autowired(required = false)
    private TopicDetailMapper topicDetailMapper;

    private int queryNum = 0; //测试使用

    @RequestMapping("/tucao/topic/detail/query/{topicId}")
    public TopicDetailListVo queryTopicDetail(@PathVariable("topicId") String req) throws Exception {
        System.out.println("req  : " + req);
        TopicDetailListVo topicDetailVo = new TopicDetailListVo();
        List<TopicDetailPo> list = topicDetailMapper.selectByTopicId(req);
        if (list.size() == 0 || list.isEmpty()){
            throw new Exception("sorry query no data");
        }
        topicDetailVo.setTopicDetaildata(list);
        queryNum++;
        System.out.println("query success" + queryNum);
        return topicDetailVo;
    }
}
