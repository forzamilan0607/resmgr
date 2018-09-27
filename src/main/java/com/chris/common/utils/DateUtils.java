package com.chris.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理
 * 
 * @author chris
 * @email 258321511@qq.com
 * @date 2016年12月21日 下午12:53:33
 */
public class DateUtils {
	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	public static String format(Date date) {
        return format(date, DATE_PATTERN);
    }

    public static String format(Date date, String pattern) {
        if(date != null){
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return currentDateStr();
    }

    public static String currentDateStr() {
	    return currentDateStr(DATE_PATTERN);
    }
    public static String currentDateStr(String pattern) {
	    return format(new Date(), pattern);
    }

    public static Date currentDate() {
	    return new Date();
    }

    public static Date parseDate(String dateStr) {
	    return parseDate(dateStr, "yyyy-MM-dd HH:mm:ss");
    }
    public static Date parseDate(String dateStr, String pattern) {

        DateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {

            throw new RuntimeException("date format error");
        }
    }
}
