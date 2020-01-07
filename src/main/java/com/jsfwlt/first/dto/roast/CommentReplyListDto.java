package com.jsfwlt.first.dto.roast;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CommentReplyListDto {
    private Integer commentId;

    private String commentContent;

    private Integer topicAnswerId;

    private Integer userId;

    private String userNickname;

    private Integer likeNumber;

    private Integer dislikeNumber;

    private Boolean logicDelete;

    private String createTime;

    private String modifyTime;

    private List<ReplyDto> replyList = new ArrayList<>();
}
