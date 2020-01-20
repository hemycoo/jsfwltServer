package com.jsfwlt.first.interceptor;

import com.jsfwlt.first.dto.jwt.CheckResult;
import com.jsfwlt.first.mapper.roast.LoginTokenPoMapper;
import com.jsfwlt.first.mapper.user.UserInfoPoMapper;
import com.jsfwlt.first.po.roast.HostHolder;
import com.jsfwlt.first.po.user.UserInfoPo;
import com.jsfwlt.first.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

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

    private static final Logger LOGGER = LoggerFactory.getLogger(PassportInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LOGGER.info("URL : " + request.getRequestURL().toString());
        LOGGER.info("HTTP_METHOD : " + request.getMethod());
        LOGGER.info("IP : " + request.getRemoteAddr());
        LOGGER.info("TOKEN : " + request.getHeader("token"));
        LOGGER.info("Authorization : " + request.getHeader("Authorization"));
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String name = (String) enu.nextElement();
            LOGGER.info("name:{},value:{}", name, request.getParameter(name));
        }
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
