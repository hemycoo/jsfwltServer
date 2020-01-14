package com.jsfwlt.first.dto.jwt;

import io.jsonwebtoken.Claims;
import lombok.Data;

/**
 * @author 十方飞鱼
 * @date 2020/1/14 10:37
 */
@Data
public class CheckResult {
    Boolean success;

    Claims claims;

    String ErrorCode;

}
