package com.jsfwlt.first.controller;

import com.jsfwlt.first.mapper.TestMapper;
import com.jsfwlt.first.vo.TestVo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestUrl1 {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/test")
    public TestVo1 testUrl(){
        TestVo1 testVo1 = new TestVo1();
        testVo1.setName(testMapper.selectByTid(1).getName());
        testVo1.setAge(testMapper.selectByTid(1).getAge());
        System.out.println("test success");
        return testVo1;
    }
}
