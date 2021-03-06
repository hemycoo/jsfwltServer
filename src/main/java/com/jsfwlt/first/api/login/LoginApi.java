package com.jsfwlt.first.api.login;


import com.jsfwlt.first.po.user.UserInfoPo;
import com.jsfwlt.first.service.user.UserInfoService;
import com.jsfwlt.first.utils.EncryptUtils;
import com.jsfwlt.first.vo.user.LoginVo;
import com.jsfwlt.first.vo.user.UserInfoResp;
import com.jsfwlt.first.vo.user.UserInfoReq;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class LoginApi {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/register")
    public UserInfoResp userRegister(UserInfoReq userInfoReq){
        Map<String,String> map = userInfoService.register(userInfoReq);
        UserInfoResp userInfoResp = new UserInfoResp();
        if(!map.containsKey("token")){
            userInfoResp.setStatus("201");
        }
        userInfoResp.setMap(map);
        return userInfoResp;
    }

    @GetMapping("/login")
    public LoginVo userLogin(@RequestParam("userName") String userName, @RequestParam("userPassword") String userPassword){
        LoginVo loginVo = new LoginVo();
        Map<String, String> map = userInfoService.login(userName, userPassword);
        if(!map.containsKey("token")){
            loginVo.setStatus("201");
        }
        loginVo.setMap(map);
        return loginVo;
    }

}
