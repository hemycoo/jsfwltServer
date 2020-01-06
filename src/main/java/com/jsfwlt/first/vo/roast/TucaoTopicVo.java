package com.jsfwlt.first.vo.roast;


import com.jsfwlt.first.dto.roast.TucaoTopicDto;
import com.jsfwlt.first.vo.BaseResp;
import lombok.Data;

@Data
public class TucaoTopicVo extends BaseResp {
    TucaoTopicDto data;
    public void setData(TucaoTopicDto data){
        this.data = data;
    }
}
