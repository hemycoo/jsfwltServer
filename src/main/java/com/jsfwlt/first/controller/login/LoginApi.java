package com.jsfwlt.first.controller.login;


import com.jsfwlt.first.mapper.tucao.UserInfoMapper;
import com.jsfwlt.first.po.tucao.UserInfoPo;
import com.jsfwlt.first.service.tucao.UserInfoService;
import com.jsfwlt.first.utils.EncryptUtils;
import com.jsfwlt.first.utils.IdGenerator;
import com.jsfwlt.first.vo.tucao.LoginVo;
import com.jsfwlt.first.vo.tucao.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class LoginApi {
    @Autowired(required = false)
    UserInfoMapper userInfoMapper;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/register")
    public RegisterVo userRegister(UserInfoPo userInfoPo){
        RegisterVo registerVo = new RegisterVo();
        userInfoPo.setUserId(IdGenerator.idGenerate("urid"));
        String userNickname = userInfoPo.getUserNickname();
        if(userInfoMapper.selectByUserNickname(userNickname) != null){
            registerVo.setStatus("201");   //暂时用201表示用户已存在
            registerVo.setMessage("用户昵称已经存在");
            return registerVo;
        }
        userInfoPo.setUserPassword(EncryptUtils.encryptMD5(userInfoPo.getUserPassword()));
        userInfoMapper.insert(userInfoPo);
        registerVo.setUserNickname(userNickname);
        return registerVo;
    }

    @RequestMapping("/login")
    public LoginVo userLogin(@RequestParam("userNickname") String userNickname, @RequestParam("userPassword") String userPassword,
    HttpServletResponse response){
        LoginVo loginVo = new LoginVo();
        try {
            Map<String, Object> map = userInfoService.login(userNickname, userPassword);
            if (map.containsKey("token")) {
                Cookie cookie = new Cookie("token", map.get("token").toString());
                cookie.setPath("/");      //设置访问的域名为所有的域名
                cookie.setMaxAge(3600 * 24 * 5);//设置cookie过期时间为5天
                //cookie.setDomain("localhost");
                response.addCookie(cookie);
                loginVo.setMap(map);
                loginVo.setUserNickname(userNickname);
                return loginVo;
            }
            loginVo.setMap(map);
        }catch (Exception e){
            e.printStackTrace();
            loginVo.setMessage("登录异常");
            return loginVo;
        }
//         UserInfoPo userInfoPo = userInfoMapper.selectByUserNickname(userNickname);
//         String realPassword = userInfoPo.getUserPassword();
//         if(EncryptUtils.encryptMD5(userPassword).equals(realPassword)){
//             loginVo.setUserNickname(userNickname);
//             loginVo.setMessage("登录成功");
//             return loginVo;
//         }
//         loginVo.setStatus("201");
//        loginVo.setMessage("用户名或者密码错误");
        return loginVo;
    }

}
