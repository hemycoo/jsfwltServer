package com.jsfwlt.first.service.user;

import com.jsfwlt.first.mapper.roast.LoginTokenPoMapper;
import com.jsfwlt.first.mapper.roast.UserInfoMapper;
import com.jsfwlt.first.po.user.LoginTokenPo;
import com.jsfwlt.first.po.user.UserInfoPo;
import com.jsfwlt.first.utils.EncryptUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserInfoService {
    @Autowired(required = false)
    UserInfoMapper userInfoMapper;

    @Autowired(required = false)
    LoginTokenPoMapper loginTokenPoMapper;

    //登录业务实现
    public Map<String,Object> login(String userNickname,String password){
        Map<String,Object> map = new HashMap<>();
        if(StringUtils.isBlank(userNickname)){
            map.put("msgname","用户名不能为空");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("msgpwd","密码不能为空");
            return map;
        }
        UserInfoPo userInfoPo = userInfoMapper.selectByUserNickname(userNickname);
        if(userInfoPo == null){
            map.put("msgname","用户名不存在");
            return map;
        }
        if(!EncryptUtils.encryptMD5(password).equals(userInfoPo.getUserPassword())){
            map.put("msgpwd","密码错误");
            return map;
        }
        map.put("userId",userInfoPo.getUserId());
        //String token = addLoginTicket(userInfoPo.getUserId());
        //map.put("token",token);
        return map;
    }
    //添加ticket
    private  String addLoginTicket(String userId){
        LoginTokenPo loginTokenPo = new LoginTokenPo();
        loginTokenPo.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        loginTokenPo.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTokenPo.setExpired(date);
        loginTokenPo.setStatus(0);
        //loginTokenPoMapper.insert(loginTokenPo);
        return loginTokenPo.getToken();
    }

}
