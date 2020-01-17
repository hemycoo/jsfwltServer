package com.jsfwlt.first.po.roast;

import lombok.Data;

import java.util.Date;

/**
 * @author 十方飞鱼
 * @date 2020/1/17 16:09
 */
@Data
public class TopicContentPo {
    private Integer contentId;

    private String content;

    private Boolean logicDelete;

    private Date createTime;

    private Date modifyTime;

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Boolean getLogicDelete() {
        return logicDelete;
    }

    public void setLogicDelete(Boolean logicDelete) {
        this.logicDelete = logicDelete;
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