package com.jsfwlt.first.dto.roast;

import lombok.Data;

@Data
public class TopicDetailDto {
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
