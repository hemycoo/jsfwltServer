package com.jsfwlt.first.vo.tucao;

import com.jsfwlt.first.vo.BaseVo;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class LoginVo extends BaseVo {
    String userNickname;
    Map<String,Object> map = new HashMap<>();
}
