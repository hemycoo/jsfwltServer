package com.jsfwlt.first.vo.tucao;


import com.jsfwlt.first.po.tucao.TucaoTopicPo;
import com.jsfwlt.first.vo.BaseVo;
import lombok.Data;

@Data
public class TucaoTopicVo extends BaseVo {
    TucaoTopicPo data;
    public void setData(TucaoTopicPo data){
        this.data = data;
    }
}
