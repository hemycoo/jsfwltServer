package com.jsfwlt.first.vo.tucao;

import com.jsfwlt.first.po.tucao.TopicDetailPo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TopicDetailListVo {
    List<TopicDetailPo> data = new ArrayList<>();
}
