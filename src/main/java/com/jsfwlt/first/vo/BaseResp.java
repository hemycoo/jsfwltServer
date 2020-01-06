package com.jsfwlt.first.vo;


import lombok.Data;

@Data
public class BaseResp {
    private String status = "200";
    private String message = "success";
}
