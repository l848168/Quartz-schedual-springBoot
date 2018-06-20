package com.zjs.del.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public final static String DATEFORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";
	
    public static String getYearMonthDay() {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format(new Date());
    }
    public static String getyyyyMMddHHmmssSSS() {
    	SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    	return format.format(new Date());
    }
	public static String getYMDHMS() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
	}
	
	
	public static Date strToDate(String timeStr, String timeFormat) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        return format.parse(timeStr);
    }
	
}
