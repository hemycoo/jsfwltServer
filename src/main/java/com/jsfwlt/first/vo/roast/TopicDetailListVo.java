package com.jsfwlt.first.vo.roast;


import com.jsfwlt.first.dto.roast.TopicDetailDto;
import com.jsfwlt.first.vo.BaseVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TopicDetailListVo extends BaseVo {
    List<TopicDetailDto> topicDetaildata = new ArrayList<>();
}
