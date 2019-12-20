package com.jsfwlt.first.utils;

import com.sun.xml.internal.bind.v2.TODO;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    //TODO 在从数据库取出数据时将datatime类型转换为标准String类型

    public static String date2String(Date times) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String newDate = dataFormat.format(times);
        return newDate;
    }

    public static String time2String(Date times) {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = dataFormat.format(times);
        return newDate;
    }
}
