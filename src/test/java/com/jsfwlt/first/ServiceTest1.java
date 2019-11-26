package com.jsfwlt.first;

import com.jsfwlt.first.service.DataGenerateService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceTest1 extends BaseTest {

    @Autowired
    private DataGenerateService serviceTest;

    @Test
    public void generateDataTset(){
        serviceTest.dataGenerate();
        System.out.println("test generate success");
    }
}
