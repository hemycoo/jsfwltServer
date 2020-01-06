package com.jsfwlt.first.vo.roast;

import com.jsfwlt.first.dto.roast.TucaoTopicDto;
import com.jsfwlt.first.vo.BaseResp;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TucaoTopicListVo extends BaseResp {
    List<TucaoTopicDto> data = new ArrayList<>();
}
