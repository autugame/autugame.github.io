package com.qf.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    //1，字符串转换成util.date
    public static java.util.Date strToUtil(String str) {
        try {
            java.util.Date date = sdf.parse(str);
            return date;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    //2，util.date转换成sql.date
    public static java.sql.Date utilToSql(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }


    //3，util.date转换成字符串
    public static String utilToStr(java.util.Date date) {
        return sdf.format(date);
    }
}
