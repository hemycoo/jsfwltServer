package com.jsfwlt.first.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
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
