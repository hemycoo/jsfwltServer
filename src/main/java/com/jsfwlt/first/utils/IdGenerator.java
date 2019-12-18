package com.jsfwlt.first.utils;


import com.jsfwlt.first.exception.SelfException;

import java.util.Arrays;
import java.util.Date;

import static com.jsfwlt.first.utils.TimeUtils.time2String;

/**
 * abcd     +          yyyy mm dd hh mm ss   + abcdefgh
 * 4位表代号 + 14位时间  年   月 日 时 分 秒   + 8位随机数  = 26位
 */
public class IdGenerator {

//    private String topicId = "tpid";  //表tucao_topic的id
//    private String topicChildrenId = "tcid";  //表topic_detail的id
//    private String commentId = "cmid";  //表comment的id
//    private String userId = "urid";  //表user_info的id
//   "crid"为评论回复id
    
    public static String idGenerate(String tableInfo){
        String[] tableArray = {"tpid", "tcid", "cmid", "urid","crid"};
        if (!Arrays.asList(tableArray).contains(tableInfo)){
            throw new SelfException("00", "请输入正确的table的代号");
        }
        return tableInfo + time2String(new Date(System.currentTimeMillis())) + generateRandom();
    }
    public static String generateRandom(){
        return String.valueOf((int)(Math.random()*100000000));
    }

}
