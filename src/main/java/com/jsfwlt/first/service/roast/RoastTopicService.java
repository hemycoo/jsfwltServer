package com.jsfwlt.first.service.roast;

import com.jsfwlt.first.mapper.roast.RoastTopicPoMapper;
import com.jsfwlt.first.po.roast.RoastTopicPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoastTopicService {
    @Autowired
    RoastTopicPoMapper roastTopicPoMapper;
    public List<RoastTopicPo> pageQueryRoastTopic(){
        return roastTopicPoMapper.selectAllRoastTopic();
    }
}
