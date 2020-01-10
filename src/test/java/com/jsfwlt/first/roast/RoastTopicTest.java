package com.jsfwlt.first.roast;

import com.jsfwlt.first.BaseTest;
import com.jsfwlt.first.po.roast.RoastTopicPo;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class RoastTopicTest extends BaseTest {

    private RestTemplate template = new RestTemplate();
   @Test
    public void queryTopicTest(){
       String url = "http://localhost:8081/roast/topic/query/"+"1";
       RoastTopicPo result = template.getForObject(url, RoastTopicPo.class);
   }
}
