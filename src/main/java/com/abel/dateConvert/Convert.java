package com.abel.dateConvert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期时间戳相互转换
 * Created by fpschina on 16/2/25.
 */
public class Convert {


    /**
     * 把已有的日期转换为时间戳
     *
     * @param str
     * @return
     */
    public static long getTimestamp(String str) {
        long l = 0;
        Date date = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date != null ? date.getTime() / 1000 : -1;


    }

    /**
     * 时间戳转换为日期
     *
     * @param timeStamp
     * @return
     */

    public static String timeStampToDate(long timeStamp) {

        SimpleDateFormat utcDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
        utcDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        return utcDateFormat.format(new Date(timeStamp * 1000));
    }


    public static String getDate(String s) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat utcDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss'Z'");
        utcDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        Date date = null;
        try {
            date = simpleDateFormat.parse(s);


        } catch (ParseException e) {
            e.printStackTrace();
        }
        return utcDateFormat.format(date);
    }


}

