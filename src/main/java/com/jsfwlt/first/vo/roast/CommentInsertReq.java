package com.jsfwlt.first.vo.roast;

import lombok.Data;

@Data
public class CommentInsertReq {
    private int topicAnswerId;
    private String commentContent;
}
