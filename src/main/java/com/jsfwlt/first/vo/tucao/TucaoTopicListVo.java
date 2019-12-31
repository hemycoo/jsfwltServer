package com.jsfwlt.first.vo.tucao;

import com.jsfwlt.first.dto.roast.TucaoTopicDto;
import com.jsfwlt.first.vo.BaseVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TucaoTopicListVo extends BaseVo {
    List<TucaoTopicDto> data = new ArrayList<>();
}
