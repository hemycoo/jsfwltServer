package com.jsfwlt.first.dto.tucao;

import lombok.Data;

import java.util.Date;

@Data
public class CommentReplyDto {
    private String replyId;

    private String replyContent;

    private String commentId;

    private Date replyTime;

    private String userId;

    private String userNickname;

    private Integer likeNumber;

    private Integer dislikeNumber;

    private String to;
}
