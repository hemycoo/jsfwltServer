package com.jsfwlt.first.controller.tucao;

import com.jsfwlt.first.controller.BaseApi;
import com.jsfwlt.first.mapper.tucao.TucaoTopicMapper;
import com.jsfwlt.first.mapper.tucao.UserInfoMapper;
import com.jsfwlt.first.po.tucao.TucaoTopicPo;
import com.jsfwlt.first.po.tucao.UserInfoPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoApi extends BaseApi {

    @Autowired(required = false)
    private UserInfoMapper userInfoMapper;

    //根据用户的ID查询
    @GetMapping("/userInfo/query")
    public UserInfoPo queryUserInfo(){
        UserInfoPo userInfoPo = userInfoMapper.selectByPrimaryKey("1");
        System.out.println("query userInfo success");
        return userInfoPo;
    }


}
