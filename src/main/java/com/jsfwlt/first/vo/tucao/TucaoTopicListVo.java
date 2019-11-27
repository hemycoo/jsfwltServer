package com.jsfwlt.first.vo.tucao;

import com.jsfwlt.first.po.tucao.TucaoTopicPo;
import com.jsfwlt.first.vo.BaseVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TucaoTopicListVo extends BaseVo {
    List<TucaoTopicPo> data = new ArrayList<>();
}
