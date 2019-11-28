package com.jsfwlt.first.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域问题解决方案第一版
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")   //前端域名，非后端域名
                .allowedMethods("*")
                .allowedHeaders("Access-Control-Allow-Origin")
                .allowCredentials(true);
    }
}
