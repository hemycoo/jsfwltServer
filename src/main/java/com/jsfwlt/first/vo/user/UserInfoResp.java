package com.jsfwlt.first.vo.user;

import com.jsfwlt.first.po.user.UserInfoPo;
import com.jsfwlt.first.vo.BaseResp;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class UserInfoResp extends BaseResp {
    Map<String,String> map = new HashMap<>();
}
