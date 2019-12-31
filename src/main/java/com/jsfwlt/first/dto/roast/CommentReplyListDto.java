package com.jsfwlt.first.dto.roast;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentReplyListDto {
    private String commentId;

    private String commentContent;

    private String commentTime;

    private String userId;

    private String userNickname;

    private Integer likeNumber;

    private Integer dislikeNumber;

    private List<ReplyDto> replyList = new ArrayList<>();
}
