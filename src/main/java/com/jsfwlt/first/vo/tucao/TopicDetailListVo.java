package com.jsfwlt.first.vo.tucao;


import com.jsfwlt.first.dto.tucao.TopicDetailDto;
import com.jsfwlt.first.vo.BaseVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TopicDetailListVo extends BaseVo {
    List<TopicDetailDto> topicDetaildata = new ArrayList<>();
}
