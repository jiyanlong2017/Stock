package com.stock.xxx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/4/1.
 */
public class DateUtils {

    public static String getDate(){
        Date date = new Date();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    public static String getYear(){
        return getDate().substring(0, 4);
    }
    public static String getMonth(){
        return getDate().substring(5, 7);
    }
    public static String getDay(){
        return getDate().substring(8, 10);
    }
}
