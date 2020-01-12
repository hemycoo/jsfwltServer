package com.jsfwlt.first.config;

import com.jsfwlt.first.interceptor.PassportInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域问题解决方案第一版
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    PassportInterceptor passportInterceptor;

    /** allowedOrigins 前端域名，非后端域名*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("*")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

    /**注册拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(passportInterceptor);
    }
}
