package com.jsfwlt.first.service;

import com.jsfwlt.first.mapper.tucao.CommentMapper;
import com.jsfwlt.first.mapper.tucao.TopicDetailMapper;
import com.jsfwlt.first.po.tucao.CommentPo;
import com.jsfwlt.first.po.tucao.TopicDetailPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Component
public class DataGenerateService {

    @Autowired(required = false)
    private CommentMapper commentMapper;

    @Autowired(required = false)
    private TopicDetailMapper topicDetailMapper;

    //生成话题详情数据
    public void dataGenerate(){
        for (int i = 0; i < 9; i++) {
            CommentPo cp = new CommentPo();
            cp.setCommentContent("CommentContent" + i);
            cp.setCommentId("cid"+i);
            cp.setCommentTime(new Date());
            cp.setDislikeNumber(i);
            cp.setLikeNumber(i + 1);
            cp.setUserId("uId" + i);
            cp.setUserNickname("name" + i);
            commentMapper.insert(cp);
        }
    }

    public void generateData(){

        for (int i = 0; i < 9; i++) {
            TopicDetailPo tp = new TopicDetailPo();
            tp.setCommentId("cid"+ i);
            tp.setContent("content"+i);
            tp.setCreationTime(new Date());
            tp.setDislikeNumber(i);
            tp.setLikeNumber(i+1);
            tp.setModificationTime(new Date());
            tp.setTopicChildrenId("chId" + i);
            tp.setTopicId("topicId" + i);
            tp.setUserId("userId" + i);
            tp.setUserNickname("name" + i);
            topicDetailMapper.insert(tp);
        }
        System.out.println("generate success");
    }
}
