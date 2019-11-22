package com.jsfwlt.first;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;



@RunWith(SpringRunner.class)
@SpringBootTest
public class FirstTest {

    private RestTemplate template = new RestTemplate();

    @Test
    public void Test1() throws JSONException {

        final String reqJson ="src/test/resources/FirstTest/Test1.json";

        String url = "http://localhost:8080/test";

        String result = template.getForObject(url,String.class);
        System.out.println("result: \n " + result);
        //Assert.assertEquals();

        JSONAssert.assertEquals(TestUtil.readJsonFile(reqJson),result,false);
    }


}
