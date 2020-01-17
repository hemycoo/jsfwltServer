package com.jsfwlt.first.interceptor;

import com.jsfwlt.first.dto.jwt.CheckResult;
import com.jsfwlt.first.mapper.roast.LoginTokenPoMapper;
import com.jsfwlt.first.mapper.user.UserInfoPoMapper;
import com.jsfwlt.first.po.roast.HostHolder;
import com.jsfwlt.first.po.user.UserInfoPo;
import com.jsfwlt.first.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 十方飞鱼
 * @date 2020/1/17 10:52
 */
@Component
public class PassportInterceptor implements HandlerInterceptor {

    @Autowired(required = false)
    LoginTokenPoMapper loginTokenPoMapper;

    @Autowired
    UserInfoPoMapper userInfoPoMapper;

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
            CheckResult checkResult = JwtTokenUtil.validateJWT(token);
            Boolean flag = checkResult.getSuccess();
            if(flag = false) {
                System.out.println("用户验证失败");
                return true;
            }
            Claims claims = JwtTokenUtil.parseJWT(token);
            String userId = claims.getId();
            UserInfoPo userInfoPo = userInfoPoMapper.selectByPrimaryKey(Integer.parseInt(userId));
            hostHolder.setUserInfoPo(userInfoPo);
            System.out.println(userInfoPo.getUserNickname());
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
