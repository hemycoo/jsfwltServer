package com.jsfwlt.first.po.roast;

import com.jsfwlt.first.po.user.UserInfoPo;
import org.springframework.stereotype.Component;

@Component
public class HostHolder {
    private static ThreadLocal<UserInfoPo> userInfoPos = new ThreadLocal<>();

    public UserInfoPo getUserInfoPo(){
        return userInfoPos.get();
    }

    public void setUserInfoPo(UserInfoPo userInfoPo){
        userInfoPos.set(userInfoPo);
    }

    public void clear(){
        userInfoPos.remove();
    }
}
