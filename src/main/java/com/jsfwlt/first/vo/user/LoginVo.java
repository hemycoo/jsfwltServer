package com.jsfwlt.first.vo.user;

import com.jsfwlt.first.vo.BaseResp;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LoginVo extends BaseResp {
    String userNickname;
    Map<String,Object> map = new HashMap<>();
}
