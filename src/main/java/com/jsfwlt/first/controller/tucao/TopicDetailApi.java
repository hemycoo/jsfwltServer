package com.jsfwlt.first.controller.tucao;

import com.jsfwlt.first.controller.BaseApi;
import com.jsfwlt.first.exception.SelfException;
import com.jsfwlt.first.mapper.tucao.TopicDetailMapper;
import com.jsfwlt.first.po.tucao.TopicDetailPo;
import com.jsfwlt.first.vo.tucao.TopicDetailListVo;
import com.jsfwlt.first.vo.tucao.TopicDetailVo;
import javafx.scene.input.DataFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@RestController
public class TopicDetailApi extends BaseApi {

    @Autowired(required = false)
    private TopicDetailMapper topicDetailMapper;

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
            TopicDetailVo topicDetailVo = new TopicDetailVo();
            BeanUtils.copyProperties(list,topicDetailVo);
            topicDetailVo.setCreationTime(date2String( list.getCreationTime()));
            topicDetailVo.setModificationTime(date2String(list.getModificationTime()));
            topicDetailListVo.getTopicDetaildata().add(topicDetailVo);
        }
        queryNum++;
        System.out.println("query success" + queryNum);
        return topicDetailListVo;
    }
    public String date2String(Date times) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
        String newDate = dataFormat.format(times);
        return newDate;
    }
}
