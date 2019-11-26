package com.jsfwlt.first.controller.tucao;

import com.jsfwlt.first.controller.BaseApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicDetailApi extends BaseApi {

    @GetMapping("/tucao/topic/detail")
    public void queryTopicDetail(){
        System.out.println("query success");
    }
}
