package com.jsfwlt.first.tucao;

import com.jsfwlt.first.BaseTest;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class TucaoTopicDetailTest extends BaseTest {

    private RestTemplate template = new RestTemplate();
   @Test
    public void CommentTest(){
       String url = "http://localhost:8081/test";
       String result = template.getForObject(url,String.class);
       System.out.println(result);
   }
}
