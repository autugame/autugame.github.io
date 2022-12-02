package com.qf.person;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestTimes {
    public static void main(String[] args) throws Exception {
        System.out.println(new Date());

        String str = "1999-09-09";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf.parse(str);
        System.out.println(date);
        System.out.println(new java.sql.Date(date.getTime()));
    }
}
