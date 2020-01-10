package com.jsfwlt.first.dto.roast;

import lombok.Data;


@Data
public class TopicAnswerDto {

    private Integer topicAnswerId;

    private String content;

    private Integer topicId;

    private Integer userId;

    private String userNickname;

    private Integer likeNumber;

    private Integer dislikeNumber;

    private String createTime;

    private String modifyTime;

}
