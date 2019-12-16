package com.jsfwlt.first.vo.tucao;

import com.jsfwlt.first.dto.tucao.CommentReplyListDto;
import com.jsfwlt.first.vo.BaseVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CommentReplyListVo extends BaseVo {
    private List<CommentReplyListDto> commentReplyData = new ArrayList<>();
}
