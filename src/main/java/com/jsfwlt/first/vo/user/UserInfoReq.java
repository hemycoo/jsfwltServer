package com.jsfwlt.first.vo.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfoReq {
    private Integer userId;

    private String userName;

    private String userNickname;

    private String userPassword;

    private String userPhone;

    private String userEmail;

    private String userSalt;

    private Date createTime;

    private Date modifyTime;
}
