package com.jsfwlt.first.service.roast;

import com.jsfwlt.first.exception.SelfException;
import com.jsfwlt.first.mapper.roast.RoastTopicPoMapper;
import com.jsfwlt.first.mapper.roast.TopicContentPoMapper;
import com.jsfwlt.first.po.roast.HostHolder;
import com.jsfwlt.first.po.roast.RoastTopicPo;
import com.jsfwlt.first.po.roast.TopicContentPo;
import com.jsfwlt.first.vo.roast.RoastTopicInsertReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author 十方飞鱼
 * @date 2020/1/17 10:52
 */
@Service
public class RoastTopicService {
    @Autowired
    RoastTopicPoMapper roastTopicPoMapper;

    @Autowired
    TopicContentPoMapper topicContentPoMapper;

    @Autowired
    HostHolder hostHolder;

    public List<RoastTopicPo> pageQueryRoastTopic(){
        return roastTopicPoMapper.selectAllRoastTopic();
    }

    /**由于添加roast_topic表需要修改两个表，因此用事务操作，目前定义为遇到运行时异常就回滚*/
    @Transactional(rollbackFor = RuntimeException.class)
    public void insertRoastTopic(RoastTopicInsertReq roastTopicInsertReq){
        String title = roastTopicInsertReq.getTitle();
        String content = roastTopicInsertReq.getContent();
        /**添加topic_content表*/
        TopicContentPo topicContentPo = new TopicContentPo();
        topicContentPo.setContent(content);
        topicContentPo.setLogicDelete(true);
        topicContentPo.setCreateTime(new Date());
        topicContentPo.setModifyTime(new Date());
        topicContentPoMapper.insert(topicContentPo);
        /**添加roast_topic表*/
        RoastTopicPo roastTopicPo = new RoastTopicPo();
        roastTopicPo.setTitle(title);
        /**取前20个字符作为内容简略*/
        roastTopicPo.setContentAbstract(getSubString(content));
        roastTopicPo.setContentId(topicContentPo.getContentId());
        roastTopicPo.setCommentNumber(0);
        roastTopicPo.setLikeNumber(0);
        roastTopicPo.setDislikeNumber(0);
        roastTopicPo.setImageUrl("http://dl.ppt123.net/pptbj/51/20181115/mzj0ghw2xo2.jpg");
        if(hostHolder.getUserInfoPo() == null){
            throw new SelfException("000","用户未登陆");
        }
        roastTopicPo.setUserId(hostHolder.getUserInfoPo().getUserId());
        roastTopicPo.setUserNickname(hostHolder.getUserInfoPo().getUserNickname());
        roastTopicPo.setLogicDelete(true);
        roastTopicPo.setCreateTime(new Date());
        roastTopicPo.setModifyTime(new Date());
        roastTopicPoMapper.insert(roastTopicPo);
    }

    private static String getSubString(String content){
        if(content.length() < 20 ){
            return content;
        }else{
            return content.substring(0,20);
        }
    }
}
