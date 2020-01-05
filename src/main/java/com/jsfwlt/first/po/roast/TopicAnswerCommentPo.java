package com.jsfwlt.first.po.roast;

import java.util.Date;

public class TopicAnswerCommentPo {
    private Integer commentId;

    private String commentContent;

    private Integer topicAnswerId;

    private Date commentTime;

    private Integer userId;

    private String userNickname;

    private Integer likeNumber;

    private Integer dislikeNumber;

    private Boolean logicDelete;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public Integer getTopicAnswerId() {
        return topicAnswerId;
    }

    public void setTopicAnswerId(Integer topicAnswerId) {
        this.topicAnswerId = topicAnswerId;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    public Integer getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    public Integer getDislikeNumber() {
        return dislikeNumber;
    }

    public void setDislikeNumber(Integer dislikeNumber) {
        this.dislikeNumber = dislikeNumber;
    }

    public Boolean getLogicDelete() {
        return logicDelete;
    }

    public void setLogicDelete(Boolean logicDelete) {
        this.logicDelete = logicDelete;
    }
}