package com.jsfwlt.first.dto.tucao;

import com.jsfwlt.first.po.tucao.ReplyPo;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CommentReplyListDto {
    private String commentId;

    private String commentContent;

    private Date commentTime;

    private String userId;

    private String userNickname;

    private Integer likeNumber;

    private Integer dislikeNumber;

    private List<ReplyPo> replyPoList = new ArrayList<>();
}
