package com.jsfwlt.first;

import com.jsfwlt.first.service.DataGenerateService;
import com.jsfwlt.first.service.roast.TopicDetailService;
import com.jsfwlt.first.utils.IdGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTest1 extends BaseTest {

    @Autowired
    private DataGenerateService serviceTest;

    @Autowired
    private TopicDetailService topicDetailService;

    @Test
    public void topicDetailGenerate(){
        //serviceTest.dataGenerate();
        //serviceTest.generateData();
        System.out.println("test generate success");
    }

    @Test
    public void commentGenerate(){
        serviceTest.commentGenerate();
        System.out.println("test generate success");
    }

    @Test
    public void insertToRoastTopicTest(){
        serviceTest.insetToRoastTopic();
    }

    @Test
    public void insertToUserInfoTest(){
        //serviceTest.insertToUserInfo();
    }

    @Test
    public void idGenTest(){
        String str = IdGenerator.idGenerate("tpid");
        System.out.println(str);
    }

    @Test
    public void tuCaoCommentServiceTest(){
        topicDetailService.selectCommentAndReplyByTopicChildrenId("chId0");
    }

    @Test
    public void tucaoCommentReplyServiceTest(){
        serviceTest.generateCommentReply();
    }

}
