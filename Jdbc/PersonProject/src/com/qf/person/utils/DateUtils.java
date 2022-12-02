package com.qf.person.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtils {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT  = new SimpleDateFormat("yyyy-MM-dd");
    //字符串转util.Date
    public static java.util.Date strToUtil(String str) {
        try {
            return SIMPLE_DATE_FORMAT.parse(str);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    //util.Date转sql.Date
    public static java.sql.Date utilToSql(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
    //util.Date转字符串
    public static String utilToStr(java.util.Date date) {
        return SIMPLE_DATE_FORMAT.format(date);
    }
}
