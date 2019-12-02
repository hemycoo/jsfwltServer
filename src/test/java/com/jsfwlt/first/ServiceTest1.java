package com.jsfwlt.first;

import com.jsfwlt.first.service.DataGenerateService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTest1 extends BaseTest {

    @Autowired
    private DataGenerateService serviceTest;

    @Test
    public void generateDataTset(){
        //serviceTest.dataGenerate();
        serviceTest.generateData();
        System.out.println("test generate success");
    }

    @Test
    public void insertToTucaoTopicTest(){
        serviceTest.insetToTucaoTopic();
    }

    @Test
    public void insertToUserInfoTest(){
        serviceTest.insertToUserInfo();
    }

}
