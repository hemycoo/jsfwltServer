package com.jsfwlt.first;

import com.jsfwlt.first.service.DataGenerateService;
import com.jsfwlt.first.service.roast.TopicAnswerService;
import com.jsfwlt.first.utils.IdGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTest1 extends BaseTest {

    @Autowired
    private DataGenerateService serviceTest;

    @Autowired
    private TopicAnswerService topicAnswerService;

    @Test
    public void topicAnswerDataGenerate(){
        serviceTest.topicAnswerDatagenerate();
        System.out.println("answer data generate success");
    }

    @Test
    public void topicAnswerCommentDataGenerate(){
        serviceTest.topicAnswerCommentDatagenerate();
        System.out.println("answer comment data generate success");
    }

    @Test
    public void topicAnswerCommentReplyDataGenerate(){
        serviceTest.commentReplyDataGenerate();
        System.out.println("answer comment reply data generate success");
    }

//    @Test
//    public void commentGenerate(){
//        serviceTest.commentGenerate();
//        System.out.println("test generate success");
//    }

    @Test
    public void insertToTucaoTopicTest(){
        serviceTest.insetToTucaoTopic();
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
        //topicAnswerService.selectCommentAndReplyByTopicChildrenId("chId0");
    }

//    @Test
//    public void tucaoCommentReplyServiceTest(){
//        serviceTest.generateCommentReply();
//    }

}
