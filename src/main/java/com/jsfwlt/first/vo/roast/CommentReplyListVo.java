package com.jsfwlt.first.vo.roast;

import com.jsfwlt.first.dto.roast.CommentReplyListDto;
import com.jsfwlt.first.vo.BaseVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentReplyListVo extends BaseVo {
    private List<CommentReplyListDto> commentReplyData = new ArrayList<>();
}
