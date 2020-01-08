package com.jsfwlt.first.vo.roast;

import com.jsfwlt.first.dto.roast.RoastTopicDto;
import com.jsfwlt.first.vo.BaseResp;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RoastTopicListVo extends BaseResp {
    List<RoastTopicDto> data = new ArrayList<>();
}
