package com.jsfwlt.first.controller;

import com.jsfwlt.first.vo.TestVo1;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestUrl1 {
    @GetMapping("/test")
    public TestVo1 testUrl(){
        TestVo1 testVo1 = new TestVo1();
        testVo1.setName("xiao2");
        testVo1.setAge("18");
        return testVo1;
    }
}
