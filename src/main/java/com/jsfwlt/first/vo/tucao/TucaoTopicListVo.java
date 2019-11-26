package com.jsfwlt.first.vo.tucao;

import com.jsfwlt.first.po.tucao.TopicDetailPo;
import com.jsfwlt.first.po.tucao.TucaoTopicPo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TucaoTopicListVo {
    List<TucaoTopicPo> data = new ArrayList<>();
}
