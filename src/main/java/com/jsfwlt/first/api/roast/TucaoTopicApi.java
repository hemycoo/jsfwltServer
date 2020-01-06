package com.jsfwlt.first.api.roast;

import com.jsfwlt.first.api.BaseApi;
import com.jsfwlt.first.dto.roast.TucaoTopicDto;
import com.jsfwlt.first.mapper.roast.TucaoTopicPoMapper;
import com.jsfwlt.first.po.roast.TucaoTopicPo;
import com.jsfwlt.first.utils.TimeUtils;
import com.jsfwlt.first.vo.roast.TucaoTopicListVo;
import com.jsfwlt.first.vo.roast.TucaoTopicVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


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
        TucaoTopicDto tucaoTopicDto = new TucaoTopicDto();
        BeanUtils.copyProperties(tucaoTopicPo,tucaoTopicDto);
        tucaoTopicVo.setData(tucaoTopicDto);
        return tucaoTopicVo;
    }

    //查询吐槽信息列表
    @GetMapping("/tucao/topic/queryAll")
    public TucaoTopicListVo queryAllTucaoTopic(){
        TucaoTopicListVo tucaoTopicListVo = new TucaoTopicListVo();
        List<TucaoTopicPo> tucaoTopicPoList = tucaoTopicPoMapper.selectAllTucaoTopic();
        List<TucaoTopicDto> tucaoTopicDtoList = new ArrayList<>();
        for (TucaoTopicPo tucaoTopicPo : tucaoTopicPoList) {
            Date date = tucaoTopicPo.getModifyTime();
            String newDate = TimeUtils.date2String(date);
            TucaoTopicDto tucaoTopicDto = new TucaoTopicDto();
            BeanUtils.copyProperties(tucaoTopicPo,tucaoTopicDto);
            tucaoTopicDto.setShowTime(newDate);
            tucaoTopicDtoList.add(tucaoTopicDto);
        }
        tucaoTopicListVo.setData(tucaoTopicDtoList);
        System.out.println("请求成功");
        return  tucaoTopicListVo;
    }

}
