package com.jsfwlt.first.controller.tucao;


import com.jsfwlt.first.mapper.tucao.UserInfoMapper;
import com.jsfwlt.first.po.tucao.UserInfoPo;
import com.jsfwlt.first.utils.EncryptUtils;
import com.jsfwlt.first.utils.IdGenerator;
import com.jsfwlt.first.vo.BaseVo;
import com.jsfwlt.first.vo.tucao.LoginVo;
import com.jsfwlt.first.vo.tucao.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginApi {
    @Autowired(required = false)
    UserInfoMapper userInfoMapper;

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
    public LoginVo userLogin(@RequestParam("userNickname") String userNickname, @RequestParam("userPassword") String userPassword){
         LoginVo loginVo = new LoginVo();
         UserInfoPo userInfoPo = userInfoMapper.selectByUserNickname(userNickname);
         String realPassword = userInfoPo.getUserPassword();
         if(EncryptUtils.encryptMD5(userPassword).equals(realPassword)){
             loginVo.setUserNickname(userNickname);
             loginVo.setMessage("登录成功");
             return loginVo;
         }
         loginVo.setStatus("201");
        loginVo.setMessage("用户名或者密码错误");
        return loginVo;
    }

}
