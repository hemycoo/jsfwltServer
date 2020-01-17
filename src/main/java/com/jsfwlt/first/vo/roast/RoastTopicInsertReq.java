package com.jsfwlt.first.vo.roast;


import lombok.Data;

/**
 * @author 十方飞鱼
 * @date 2020/1/17 11:04
 */
@Data
public class RoastTopicInsertReq{
    /**吐槽话题标题*/
    String title;

    /**话题内容*/
    String content;
}
