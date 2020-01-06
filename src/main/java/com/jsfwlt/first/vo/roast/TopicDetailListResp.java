package com.jsfwlt.first.vo.roast;


import com.jsfwlt.first.dto.roast.TopicDetailDto;
import com.jsfwlt.first.vo.BaseResp;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TopicDetailListResp extends BaseResp {
    List<TopicDetailDto> topicDetaildata = new ArrayList<>();
}
