package com.jsfwlt.first.controller.tucao;

import com.jsfwlt.first.controller.BaseApi;
import com.jsfwlt.first.mapper.tucao.TucaoTopicMapper;
import com.jsfwlt.first.po.tucao.TucaoTopicPo;
import com.jsfwlt.first.vo.tucao.TucaoTopicListVo;
import com.jsfwlt.first.vo.tucao.TucaoTopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TucaoTopicApi extends BaseApi {

    @Autowired(required = false)
    private TucaoTopicMapper tucaoTopicMapper;

    //根据吐槽的ID查询
    @GetMapping("/tucao/topic/query")
    public TucaoTopicVo queryTucaoTopic(){
        TucaoTopicPo tucaoTopicPo = tucaoTopicMapper.selectByPrimaryKey("topicId1");
        System.out.println("query TucaoTopic success");
        TucaoTopicVo tucaoTopicVo = new TucaoTopicVo();
        tucaoTopicVo.setData(tucaoTopicPo);
        return tucaoTopicVo;
    }

    //查询吐槽信息列表
    @GetMapping("/tucao/topic/queryAll")
    public TucaoTopicListVo queryAllTucaoTopic(){
        TucaoTopicListVo tucaoTopicListVo = new TucaoTopicListVo();
        tucaoTopicListVo.setData(tucaoTopicMapper.selectAllTucaoTopic());
        System.out.println("请求成功");
        return  tucaoTopicListVo;
    }

}
