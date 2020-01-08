package com.jsfwlt.first.dto.roast;

import lombok.Data;

import java.util.Date;


@Data
public class ReplyDto {
    private Integer replyId;

    private String replyContent;

    private String replyToName;

    private Integer replyToId;

    private Integer commentId;

    private Integer userId;

    private String userNickname;

    private Integer likeNumber;

    private Integer dislikeNumber;

    private Boolean logicDelete;

    private String createTime;

    private String modifyTime;
}
