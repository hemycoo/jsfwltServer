package com.jsfwlt.first.controller.tucao;

import com.jsfwlt.first.controller.BaseApi;
import com.jsfwlt.first.mapper.tucao.TopicDetailMapper;
import com.jsfwlt.first.mapper.tucao.TucaoTopicMapper;
import com.jsfwlt.first.po.tucao.TucaoTopicPo;
import com.jsfwlt.first.vo.tucao.TopicDetailListVo;
import com.jsfwlt.first.vo.tucao.TucaoTopicListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TucaoTopicApi extends BaseApi {

    @Autowired(required = false)
    private TucaoTopicMapper tucaoTopicMapper;

    //根据吐槽的ID查询
    @GetMapping("/tucao/topic/query")
    public TucaoTopicPo queryTucaoTopic(){
        TucaoTopicPo tucaoTopicPo = tucaoTopicMapper.selectByPrimaryKey("1");
        System.out.println("query TucaoTopic success");
        return tucaoTopicPo;
    }


}
