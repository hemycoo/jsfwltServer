package com.jsfwlt.first;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.jsfwlt.first.mapper.roast","com.jsfwlt.first.mapper.user"})
public class JsfwltApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsfwltApplication.class, args);
        System.out.println("start success");
    }
}
