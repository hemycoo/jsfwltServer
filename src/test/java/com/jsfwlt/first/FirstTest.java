package com.jsfwlt.first;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

public class FirstTest extends BaseTest{

    private RestTemplate template = new RestTemplate();

    @Test
    public void Test1() throws JSONException {

        final String reqJson ="src/test/resources/FirstTest/Test1.json";

        String url = "http://localhost:8081/test";

        String result = template.getForObject(url,String.class);
        System.out.println("result: \n " + result);
        //Assert.assertEquals();

        JSONAssert.assertEquals(TestUtil.readJsonFileToString(reqJson),result,false);
    }


}
