package com.jsfwlt.first.vo.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoReq {

    private String userName;

    private String userPassword;

    private String userPhone;

    private String userEmail;
}
