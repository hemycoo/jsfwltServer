package com.jsfwlt.first.vo.roast;


import com.jsfwlt.first.dto.roast.TucaoTopicDto;
import com.jsfwlt.first.vo.BaseVo;
import lombok.Data;

@Data
public class TucaoTopicVo extends BaseVo {
    TucaoTopicDto data;
    public void setData(TucaoTopicDto data){
        this.data = data;
    }
}
