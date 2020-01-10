package com.jsfwlt.first.service;

import com.jsfwlt.first.mapper.roast.*;
import com.jsfwlt.first.mapper.user.UserInfoPoMapper;
import com.jsfwlt.first.po.roast.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataGenerateService {


    @Autowired(required = false)
    private RoastTopicPoMapper roastTopicPoMapper;

    @Autowired(required = false)
    private TopicContentPoMapper topicContentPoMapper;

    @Autowired(required = false)
    private UserInfoPoMapper userInfoPoMapper;


//    //生成话题详情数据
//    public void generateData() {
//        for (int i = 50; i < 60; i++) {
//            TopicDetailPo tp = new TopicDetailPo();
//            tp.setCommentId("cid" + i);
//            tp.setContent("content" + i);
//            tp.setCreationTime(new Date());
//            tp.setDislikeNumber(i);
//            tp.setLikeNumber(i + 1);
//            tp.setModificationTime(new Date(System.currentTimeMillis()));
//            tp.setTopicChildrenId(IdGenerator.idGenerate("tcid"));
//            tp.setTopicId("topicId");
//            tp.setUserId("userId" + i);
//            tp.setUserNickname("name" + i);
//            topicDetailMapper.insert(tp);
//        }
//        System.out.println("generate success");
//    }


    //生成并插入roast_topic表和topic_content表的测试数据
    public void insetToRoastTopic() {
        RoastTopicPo roastTopicPo = new RoastTopicPo();
        TopicContentPo topicContentPo = new TopicContentPo();
        for (int i = 0; i < 15; i++) {
            Date date = new Date();
            //插入topic_content表
            topicContentPo.setContent("content"+i);
            topicContentPo.setLogicDelete(true);
            topicContentPo.setCreateTime(date);
            topicContentPo.setModifyTime(date);
            topicContentPoMapper.insert(topicContentPo);
            //插入roast_topic表
            roastTopicPo.setTitle("title" + i);
            roastTopicPo.setContentAbstract("contentAbstract"+i);
            roastTopicPo.setContentId(i);
            roastTopicPo.setCommentNumber(i);
            roastTopicPo.setLikeNumber(i);
            roastTopicPo.setDislikeNumber(i);
            roastTopicPo.setImageUrl("https://localhost/image" + i);
            roastTopicPo.setUserId(i);
            roastTopicPo.setUserNickname("userNickname"+i);
            roastTopicPo.setLogicDelete(true);
            roastTopicPo.setCreateTime(date);
            roastTopicPo.setModifyTime(date);
            roastTopicPoMapper.insert(roastTopicPo);
        }
        System.out.println("插入tucao_topic表和topic_content成功");
    }

//    //生成并插入user_info表的测试数据
//    public void insertToUserInfo() {
//        UserInfoPo userInfoPo = new UserInfoPo();
//        for (int i = 0; i < 15; i++) {
//            userInfoPo.setUserId("userId" + i);
//            userInfoPo.setUserNickname("nick" + i);
//            userInfoPo.setUserPassword("userPassword" + i);
//            userInfoPo.setUserPhone("userPhone" + i);
//            userInfoPo.setUserEmail("userEmail" + i);
//            userInfoMapper.insert(userInfoPo);
//        }
//        System.out.println("插入user_info表成功");
//    }

}
