package com.jsfwlt.first.service;

import com.jsfwlt.first.mapper.roast.*;
import com.jsfwlt.first.po.roast.CommentReplyPo;
import com.jsfwlt.first.po.roast.TopicAnswerCommentPo;
import com.jsfwlt.first.po.roast.TopicAnswerPo;
import com.jsfwlt.first.po.roast.TucaoTopicPo;
import com.jsfwlt.first.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataGenerateService {

    @Autowired(required = false)
    private TucaoTopicPoMapper tucaoTopicPoMapper;

    @Autowired(required = false)
    private UserInfoMapper userInfoMapper;

    //生成topic_answer表数据
    @Autowired
    private TopicAnswerPoMapper topicAnswerPoMapper;

    public void topicAnswerDatagenerate(){
        for (int i = 0; i < 30; i++) {
            Date date = new Date();

            TopicAnswerPo topicAnswerPo = new TopicAnswerPo();
            topicAnswerPo.setContent("content" + i);
            topicAnswerPo.setDislikeNumber(i);
            topicAnswerPo.setLikeNumber(i + 1);
            topicAnswerPo.setLogicDelete(true);
            topicAnswerPo.setTopicId(1);
            topicAnswerPo.setUserId(1);
            topicAnswerPo.setUserNickname("nick");
            topicAnswerPo.setCreateTime(date);
            topicAnswerPo.setModifyTime(date);

            topicAnswerPoMapper.insertSelective(topicAnswerPo);
        }
    }

    //生成topic_answer_comment数据
    @Autowired
    private TopicAnswerCommentPoMapper topicAnswerCommentPoMapper;

    public void topicAnswerCommentDatagenerate(){
        for (int i = 0; i < 30; i++) {
            Date date = new Date();
            TopicAnswerCommentPo topicAnswerCommentPo = new TopicAnswerCommentPo();
            topicAnswerCommentPo.setCommentContent("comment content");
            topicAnswerCommentPo.setTopicAnswerId(1);
            topicAnswerCommentPo.setUserId(1);
            topicAnswerCommentPo.setUserNickname("name");
            topicAnswerCommentPo.setLikeNumber(i);
            topicAnswerCommentPo.setDislikeNumber(i);
            topicAnswerCommentPo.setLogicDelete(true);
            topicAnswerCommentPo.setCreateTime(date);
            topicAnswerCommentPo.setModifyTime(date);

            topicAnswerCommentPoMapper.insertSelective(topicAnswerCommentPo);
        }
    }

    //生成comment_reply数据
    @Autowired
    private CommentReplyPoMapper commentReplyPoMapper;

    public void commentReplyDataGenerate(){
        for (int i = 0; i < 30; i++) {
            Date date = new Date();

            CommentReplyPo commentReplyPo = new CommentReplyPo();
            commentReplyPo.setReplyContent("reply content");
            commentReplyPo.setReplyToName("san");
            commentReplyPo.setReplyToId(i);
            commentReplyPo.setCommentId(1);
            commentReplyPo.setUserId(1);
            commentReplyPo.setUserNickname("wu");
            commentReplyPo.setLikeNumber(i);
            commentReplyPo.setDislikeNumber(i);
            commentReplyPo.setLogicDelete(true);
            commentReplyPo.setCreateTime(date);
            commentReplyPo.setModifyTime(date);

            commentReplyPoMapper.insertSelective(commentReplyPo);
        }
    }

    //生成并插入tucao_topic表的测试数据
    public void insetToTucaoTopic() {
        TucaoTopicPo tucaoTopicPo = new TucaoTopicPo();
        for (int i = 0; i < 15; i++) {
            tucaoTopicPo.setTopicId(IdGenerator.idGenerate("tpid"));
            tucaoTopicPo.setTitle("title" + i);
            tucaoTopicPo.setContent("content" + i);
            tucaoTopicPo.setCommentNumber(i);
            tucaoTopicPo.setLikeNumber(i);
            tucaoTopicPo.setDislikeNumber(i);
            tucaoTopicPo.setImageUrl("https://localhost/image" + i);
            tucaoTopicPo.setUserId("userId" + i);
            tucaoTopicPoMapper.insert(tucaoTopicPo);
            tucaoTopicPo.setImageUrl("https://localhost/image"+i);
            tucaoTopicPo.setUserId("userId"+i);
            tucaoTopicPoMapper.insert(tucaoTopicPo);
        }
        System.out.println("插入tucao_topic表成功");
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
