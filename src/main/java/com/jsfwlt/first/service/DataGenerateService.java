package com.jsfwlt.first.service;

import com.jsfwlt.first.mapper.tucao.*;
import com.jsfwlt.first.po.tucao.*;
import com.jsfwlt.first.po.tucao.CommentPo;
import com.jsfwlt.first.po.tucao.TopicDetailPo;
import com.jsfwlt.first.po.tucao.TucaoTopicPo;
import com.jsfwlt.first.po.tucao.UserInfoPo;
import com.jsfwlt.first.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataGenerateService {

    @Autowired(required = false)
    private ReplyPoMapper replyPoMapper;

    @Autowired(required = false)
    private CommentPoMapper commentPoMapper;

    @Autowired(required = false)
    private TopicDetailMapper topicDetailMapper;

    @Autowired(required = false)
    private TucaoTopicPoMapper tucaoTopicPoMapper;

    @Autowired(required = false)
    private UserInfoMapper userInfoMapper;

    //生成评论详情数据
    public void commentGenerate() {
        for (int i = 0; i < 9; i++) {
            CommentPo cp = new CommentPo();
            cp.setCommentContent("CommentContent" + i);
            cp.setCommentId(IdGenerator.idGenerate("cmid"));
            cp.setTopicChildrenId("chId0");
            cp.setCommentTime(new Date());
            cp.setDislikeNumber(i);
            cp.setLikeNumber(i + 1);
            cp.setUserId("uId" + i);
            cp.setUserNickname("name" + i);
            commentPoMapper.insertSelective(cp);
        }
    }

    //生成话题详情数据
    public void generateData() {
        for (int i = 50; i < 60; i++) {
            TopicDetailPo tp = new TopicDetailPo();
            tp.setCommentId("cid" + i);
            tp.setContent("content" + i);
            tp.setCreationTime(new Date());
            tp.setDislikeNumber(i);
            tp.setLikeNumber(i + 1);
            tp.setModificationTime(new Date(System.currentTimeMillis()));
            tp.setTopicChildrenId(IdGenerator.idGenerate("tcid"));
            tp.setTopicId("topicId");
            tp.setUserId("userId" + i);
            tp.setUserNickname("name" + i);
            topicDetailMapper.insert(tp);
        }
        System.out.println("generate success");
    }

    //生成评论回复数据
    public void generateCommentReply(){
        for (int i = 0; i < 20; i++) {
            ReplyPo replyPo = new ReplyPo();
            replyPo.setCommentId(IdGenerator.idGenerate("cmid"));
            replyPo.setDislikeNumber(i);
            replyPo.setLikeNumber(i);
            replyPo.setReplyContent(i + "reply" + i);
            replyPo.setReplyId(IdGenerator.idGenerate("crid"));
            replyPo.setReplyTime(new Date(System.currentTimeMillis()));
            replyPo.setUserId(IdGenerator.idGenerate("urid"));
            replyPo.setUserNickname("acr" + i);
            replyPo.setReplyToId(IdGenerator.idGenerate("urid"));
            replyPo.setReplyToName("name"+i);
            replyPoMapper.insertSelective(replyPo);
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

    //生成并插入user_info表的测试数据
    public void insertToUserInfo() {
        UserInfoPo userInfoPo = new UserInfoPo();
        for (int i = 0; i < 15; i++) {
            userInfoPo.setUserId("userId" + i);
            userInfoPo.setUserNickname("nick" + i);
            userInfoPo.setUserPassword("userPassword" + i);
            userInfoPo.setUserPhone("userPhone" + i);
            userInfoPo.setUserEmail("userEmail" + i);
            userInfoMapper.insert(userInfoPo);
        }
        System.out.println("插入user_info表成功");
    }

}
