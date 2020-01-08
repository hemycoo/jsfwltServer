package com.jsfwlt.first.vo.roast;


import com.jsfwlt.first.dto.roast.RoastTopicDto;
import com.jsfwlt.first.vo.BaseResp;
import lombok.Data;

@Data
public class RoastTopicVo extends BaseResp {
    RoastTopicDto data;
    public void setData(RoastTopicDto data){
        this.data = data;
    }
}
