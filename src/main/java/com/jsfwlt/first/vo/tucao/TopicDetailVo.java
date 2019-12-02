package com.jsfwlt.first.vo.tucao;

import lombok.Data;

@Data
public class TopicDetailVo {
    private String topicChildrenId;

    private String content;

    private String creationTime;

    private String modificationTime;

    private String topicId;

    private String commentId;

    private String userId;

    private String userNickname;

    private Integer likeNumber;

    private Integer dislikeNumber;
}
