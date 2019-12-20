package com.jsfwlt.first.dto.tucao;

import lombok.Data;


@Data
public class ReplyDto {
    private String replyId;

    private String replyContent;

    private String replyToName;

    private String replyToId;

    private String commentId;

    private String replyTime;

    private String userId;

    private String userNickname;

    private Integer likeNumber;

    private Integer dislikeNumber;
}
