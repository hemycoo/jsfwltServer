package com.jsfwlt.first.vo.roast;

import com.jsfwlt.first.dto.roast.CommentReplyListDto;
import com.jsfwlt.first.vo.BaseResp;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentReplyListResp extends BaseResp {
    private List<CommentReplyListDto> commentReplyData = new ArrayList<>();
}
