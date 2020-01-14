package com.jsfwlt.first.service.user;

import com.jsfwlt.first.mapper.roast.LoginTokenPoMapper;
import com.jsfwlt.first.mapper.user.UserInfoPoMapper;
import com.jsfwlt.first.po.user.LoginTokenPo;
import com.jsfwlt.first.po.user.UserInfoPo;
import com.jsfwlt.first.utils.EncryptUtils;
import com.jsfwlt.first.utils.JwtTokenUtil;
import com.jsfwlt.first.vo.user.UserInfoReq;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author 十方飞鱼
 * @date 2020/1/13 15:51
 */
@Service
public class UserInfoService {
    @Autowired
    UserInfoPoMapper userInfoPoMapper;

    @Autowired
    LoginTokenPoMapper loginTokenPoMapper;

    /**
     * 注册业务实现
     */
    public Map<String,String> register(UserInfoReq userInfoReq){
        Map<String,String> map = new HashMap<>();
        if(StringUtils.isBlank(userInfoReq.getUserName())){
            map.put("msgname","用户名不能为空");
            return map;
        }
        if(StringUtils.isBlank(userInfoReq.getUserPassword())){
            map.put("msgpwd","密码不能为空");
            return map;
        }
        UserInfoPo userInfoPo = userInfoPoMapper.selectByUserName(userInfoReq.getUserName());
        if(userInfoPo != null){
            map.put("msgname","用户名已经存在");
            return map;
        }
        /**注册用户*/
        String userName = userInfoReq.getUserName();
        String userEmail = userInfoReq.getUserEmail();
        String userPhone = userInfoReq.getUserPhone();
        userInfoPo = new UserInfoPo();
        userInfoPo.setUserName(userName);
        userInfoPo.setUserNickname(createUserNickName());
        userInfoPo.setUserEmail(userEmail);
        userInfoPo.setUserPhone(userPhone);
        userInfoPo.setCreateTime(new Date());
        userInfoPo.setModifyTime(new Date());
        /**用UUID生成盐*/
        String salt = UUID.randomUUID().toString().substring(0,18).replaceAll("-","");

        String password = userInfoReq.getUserPassword();
        /**生成密码的密文*/
        userInfoPo.setUserPassword(EncryptUtils.encryptMD5(password,salt));
        /**将用户添加到数据库*/
        userInfoPoMapper.insert(userInfoPo);
        /**生成token，并返回给前端*/
        String token = addLoginToken(userInfoPoMapper.selectByUserName(userName).getUserId());
        // TODO: 2020/1/7 把token存入redis



        map.put("userNickname",userInfoPo.getUserNickname());
        map.put("token",token);
        return map;
    }

    /**
     *  登录业务实现
     */
    public Map<String,String> login(String userName,String password){
        Map<String,String> map = new HashMap<>();
        if(StringUtils.isBlank(userName)){
            map.put("msgname","用户名不能为空");
            return map;
        }
        if(StringUtils.isBlank(password)){
            map.put("msgpwd","密码不能为空");
            return map;
        }
        UserInfoPo userInfoPo = userInfoPoMapper.selectByUserName(userName);
        if(userInfoPo == null){
            map.put("msgname","用户名不存在");
            return map;
        }
        /**获取密码的密文，提取salt*/
        String encryptPassword = userInfoPo.getUserPassword();
        String salt = EncryptUtils.getSaltFromHash(encryptPassword);
        if(!EncryptUtils.encryptMD5(password,salt).equals(userInfoPo.getUserPassword())){
            map.put("msgpwd","密码错误");
            return map;
        }
        map.put("userNickname",userInfoPo.getUserNickname());
        String userId = userInfoPo.getUserId().toString();
        String JWT = JwtTokenUtil.createJWT(userId, userName, 604800);
        map.put("token",JWT);
        return map;
    }
    /**生成token*/
    private  String addLoginToken(int userId){
        LoginTokenPo loginTokenPo = new LoginTokenPo();
        loginTokenPo.setUserId(userId);
        Date date = new Date();
        date.setTime(date.getTime() + 1000*3600*24);
        loginTokenPo.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        loginTokenPo.setExpired(date);
        loginTokenPo.setStatus(0);
        return loginTokenPo.getToken();
    }

    /**生成默认的用户昵称*/
    private String createUserNickName(){
        return "用户"+UUID.randomUUID().toString().substring(0,8).replaceAll("-","");
    }

}
