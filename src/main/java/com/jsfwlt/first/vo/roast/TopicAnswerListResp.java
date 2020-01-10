package com.jsfwlt.first.vo.roast;


import com.jsfwlt.first.dto.roast.TopicAnswerDto;
import com.jsfwlt.first.vo.BaseResp;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TopicAnswerListResp extends BaseResp {
    List<TopicAnswerDto> topicAnswerData = new ArrayList<>();
}
