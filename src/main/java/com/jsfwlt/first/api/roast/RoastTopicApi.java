package com.jsfwlt.first.api.roast;

import com.github.pagehelper.PageHelper;
import com.jsfwlt.first.api.BaseApi;
import com.jsfwlt.first.dto.roast.RoastTopicDto;
import com.jsfwlt.first.exception.SelfException;
import com.jsfwlt.first.mapper.roast.RoastTopicPoMapper;
import com.jsfwlt.first.po.roast.RoastTopicPo;
import com.jsfwlt.first.service.roast.RoastTopicService;
import com.jsfwlt.first.utils.TimeUtils;
import com.jsfwlt.first.vo.roast.RoastTopicListVo;
import com.jsfwlt.first.vo.roast.RoastTopicVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
public class RoastTopicApi extends BaseApi {

    @Autowired
    private RoastTopicPoMapper roastTopicPoMapper;

    @Autowired
    private RoastTopicService roastTopicService;

    //根据吐槽的ID查询
    @GetMapping("/roast/topic/query/{topicId}")
    public RoastTopicVo queryTucaoTopic(@PathVariable("topicId")int topicId){
        RoastTopicPo roastTopicPo = roastTopicPoMapper.selectByPrimaryKey(topicId);
        if(roastTopicPo == null){
            throw new SelfException("001","编号"+topicId+"没找到");
        }
        RoastTopicVo roastTopicVo = new RoastTopicVo();
        RoastTopicDto roastTopicDto = new RoastTopicDto();
        BeanUtils.copyProperties(roastTopicPo,roastTopicDto);
        roastTopicVo.setData(roastTopicDto);
        return roastTopicVo;
    }

    //分页查询吐槽话题
    @GetMapping("/roast/topic/queryAll")
    public RoastTopicListVo queryAllTucaoTopic(@RequestParam(defaultValue = "1") int p,
                                               @RequestParam(defaultValue = "8") int size){
        RoastTopicListVo roastTopicListVo = new RoastTopicListVo();
        PageHelper.startPage(p,size);
        List<RoastTopicPo> roastTopicPoList = roastTopicService.pageRoastTopic();
        List<RoastTopicDto> roastTopicDtoList = new ArrayList<>();
        for (RoastTopicPo roastTopicPo : roastTopicPoList) {
            Date date = roastTopicPo.getModifyTime();
            String newDate = TimeUtils.date2String(date);
            RoastTopicDto roastTopicDto = new RoastTopicDto();
            BeanUtils.copyProperties(roastTopicPo,roastTopicDto);
            roastTopicDto.setShowTime(newDate);
            roastTopicDtoList.add(roastTopicDto);
        }
        roastTopicListVo.setData(roastTopicDtoList);
        System.out.println("查询所有吐槽表信息成功");
        return  roastTopicListVo;
    }

}
