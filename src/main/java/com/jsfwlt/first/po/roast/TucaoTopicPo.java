package com.jsfwlt.first.po.roast;

import java.util.Date;

public class TucaoTopicPo {
    private String topicId;

    private String title;

    private String content;

    private Integer commentNumber;

    private Integer likeNumber;

    private Integer dislikeNumber;

    private String imageUrl;

    private String userId;

    private Date createTime;

    private Date modifyTime;

    public String getTopicId() {
        return topicId;
    }

    public void setTopicId(String topicId) {
        this.topicId = topicId == null ? null : topicId.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(Integer commentNumber) {
        this.commentNumber = commentNumber;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}