package com.jsfwlt.first.controller.tucao;

import com.jsfwlt.first.controller.BaseApi;
import com.jsfwlt.first.mapper.tucao.TucaoTopicPoMapper;
import com.jsfwlt.first.po.tucao.TucaoTopicPo;
import com.jsfwlt.first.vo.tucao.TucaoTopicListVo;
import com.jsfwlt.first.vo.tucao.TucaoTopicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TucaoTopicApi extends BaseApi {

    @Autowired(required = false)
    private TucaoTopicPoMapper tucaoTopicPoMapper;

    //根据吐槽的ID查询
    @GetMapping("/tucao/topic/query/{topicId}")
    public TucaoTopicVo queryTucaoTopic(@PathVariable("topicId")String topicId)throws Exception{
        TucaoTopicPo tucaoTopicPo = tucaoTopicPoMapper.selectByPrimaryKey(topicId);
        if(tucaoTopicPo == null){
            throw new Exception("sorry query no data");
        }
        TucaoTopicVo tucaoTopicVo = new TucaoTopicVo();
        tucaoTopicVo.setData(tucaoTopicPo);
        return tucaoTopicVo;
    }

    //查询吐槽信息列表
    @GetMapping("/tucao/topic/queryAll")
    public TucaoTopicListVo queryAllTucaoTopic(){
        TucaoTopicListVo tucaoTopicListVo = new TucaoTopicListVo();
        tucaoTopicListVo.setData(tucaoTopicPoMapper.selectAllTucaoTopic());
        System.out.println("请求成功");
        return  tucaoTopicListVo;
    }

}
