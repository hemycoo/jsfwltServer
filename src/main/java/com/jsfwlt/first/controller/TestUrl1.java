package com.jsfwlt.first.controller;

import com.jsfwlt.first.mapper.Test2Mapper;
import com.jsfwlt.first.mapper.TestMapper;
import com.jsfwlt.first.vo.TestVo1;
import com.jsfwlt.first.vo.TestVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestUrl1 {

    @Autowired(required = false)
    private TestMapper testMapper;

    @Autowired(required = false)
    private Test2Mapper test2Mapper;

    @GetMapping("/test")
    public TestVo1 testUrl(){
        TestVo1 testVo1 = new TestVo1();
        testVo1.setName(testMapper.selectByTid(1).getName());
        testVo1.setAge(testMapper.selectByTid(1).getAge());
        System.out.println("test success");
        return testVo1;
    }

    @GetMapping("/mybatis")
    public TestVo2 testMybatis(){
        TestVo2 test2Po = new TestVo2();
        test2Po.setName(test2Mapper.selectByPrimaryKey(1).getName());
        test2Po.setAge(test2Mapper.selectByPrimaryKey(1).getAge());
        System.out.println("test mybatis success");
        return test2Po;
    }
}
