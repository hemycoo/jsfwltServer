package com.jsfwlt.first.interceptor;

import com.jsfwlt.first.mapper.roast.LoginTokenPoMapper;
import com.jsfwlt.first.mapper.roast.UserInfoMapper;
import com.jsfwlt.first.po.roast.HostHolder;
import com.jsfwlt.first.po.roast.LoginTokenPo;
import com.jsfwlt.first.po.roast.UserInfoPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class PassportInterceptor implements HandlerInterceptor {

    @Autowired(required = false)
    LoginTokenPoMapper loginTokenPoMapper;

    @Autowired(required = false)
    UserInfoMapper userInfoMapper;

    @Autowired
    private HostHolder hostHolder;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("我是拦截器啊");
        System.out.println(request.getCookies());
        String token = null;
        if(request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
            }
        }
        if(token != null){
            LoginTokenPo loginTokenPo = loginTokenPoMapper.selectByToken(token);
            if(loginTokenPo == null || loginTokenPo.getExpired().before(new Date()) || loginTokenPo.getStatus() != 0){
                return true;
            }
            UserInfoPo userInfoPo = userInfoMapper.selectByPrimaryKey(loginTokenPo.getUserId());
            hostHolder.setUserInfoPo(userInfoPo);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView != null && hostHolder.getUserInfoPo()!= null){
            modelAndView.addObject("user",hostHolder.getUserInfoPo());
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        hostHolder.clear();
    }
}
