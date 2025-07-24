package com.hq.acdm.util;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author lizhifeng
 * @Date 2018/9/3 0003
 * @Description:
 */
public class DateTimeUtil {

    /**
     *
     */
    public static final String STANDARD_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");


    public static Date strToDate(String dateTimeStr,String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date,String formatStr){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(STANDARD_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }
    public static Date strToDate2(String dateTimeStr){
        if(StringUtil.isEmpty(dateTimeStr)|| "null".equals(dateTimeStr)){
            return null;
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(DATE_FORMAT);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    public static String dateToStr(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(STANDARD_FORMAT);
    }

    public static String dateToStr2(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(DATE_FORMAT);
    }

    /**
     * 字符串时间比较大小
     * dateTime1<dateTime2返回true,其他返回false
     * @param dateTime1,dateTime2 cdateTime1,dateTime2 格式yyyy-MM-dd HH:mm:ss
     * @return boolean
     */
    public static boolean compareStr(String dateTime1, String dateTime2){
        if(dateTime1 == null || dateTime2 == null){
            return false;
        }
        if (dateTimeFormatter.parseDateTime(dateTime1).compareTo(dateTimeFormatter.parseDateTime(dateTime2))<0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 给时间加上几个小时
     * @param day 当前时间 格式：yyyy-MM-dd HH:mm:ss
     * @param hour 需要加的时间
     * @return
     */
    public static String addDateMinut(String day, int hour){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = format.parse(day);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (date == null)
            return "";
        System.out.println("front:" + format.format(date)); //显示输入的日期
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hour);// 24小时制
        date = cal.getTime();
        System.out.println("after:" + format.format(date));  //显示更新后的日期
        cal = null;
        return format.format(date);
    }

    /**
     * 字符串时间差
     * 返回天数
     * @param dateTime1,dateTime2 cdateTime1,dateTime2 格式yyyy-MM-dd HH:mm:ss
     * @return int
     */
    public static int subDateTime(String dateTime1, String dateTime2){
        return (int)((dateTimeFormatter.parseDateTime(dateTime1).toDate().getTime()-dateTimeFormatter.parseDateTime(dateTime2).toDate().getTime())
                /(24*60*60*1000));
    }

    /**
     * 字符串时间差
     * 返回分钟
     * @param dateTime1,dateTime2 cdateTime1,dateTime2 格式yyyy-MM-dd HH:mm:ss
     * @return int
     */
    public static int subMinDateTime(String dateTime1, String dateTime2){
        return (int)((dateTimeFormatter.parseDateTime(dateTime1).toDate().getTime()-dateTimeFormatter.parseDateTime(dateTime2).toDate().getTime())
                /(60*1000));
    }

    /**
     * 字符串时间加减分钟
     * 返回天数
     * @param dateTime,int cdateTime,int 格式yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String subMin(String dateTime, int min){
        return new SimpleDateFormat(STANDARD_FORMAT).format(new Date(dateTimeFormatter.parseDateTime(dateTime).toDate().getTime()-min*60*1000));
    }

    /**
     * 返回时间小时
     * @param dateTime cdateTime1,dateTime2 格式yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String getHour(String dateTime) throws ParseException {
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
        return  hourFormat.format(new SimpleDateFormat(STANDARD_FORMAT).parse(dateTime));
    }

    /**
     * 返回时间小时
     * @param dateTime cdateTime1,dateTime2 格式yyyy-MM-dd HH:mm:ss
     * @return String
     */
    public static String getHourMinute(String dateTime) throws ParseException {
        SimpleDateFormat hourFormat = new SimpleDateFormat("HH:mm");
        return  hourFormat.format(new SimpleDateFormat(STANDARD_FORMAT).parse(dateTime));
    }

    /**
     * 时间格式化
     * 返回时间格式：12:10(天数)
     * @param dateTime 时间字符串 2019-04-25 12:10:00
     * @return String 返回小时+分钟+天数
     */
    public static String timeDayFormatByStr(String dateTime){
        if(dateTime == null || dateTime.equals("")){
            return StringUtils.EMPTY;
        }
        /*//返回时间格式：12:10+1或者12:10-1或者12:10，写法代码
        String returnTime = dateTime.substring(11,16);
        DateTimeFormatter dtf = DateTimeFormat.forPattern(DATE_FORMAT);
        String dataStr = dateTime.substring(0,10);
        LocalDate datePar = LocalDate.parse(dataStr, dtf);
        DateTime now = new DateTime(new Date());
        LocalDate nowDate = LocalDate.parse(now.toString(DATE_FORMAT), dtf);
        long timeLong = datePar.toDate().getTime();
        long nowLong  = nowDate.toDate().getTime();
        long daysBetween = (timeLong - nowLong) / (3600*24*1000);
        if(daysBetween != 0){
            if(daysBetween > 0){
                returnTime +=  "+"+daysBetween;
            }else{
                returnTime +=  daysBetween;
            }
        }
        */
        String returnTime = dateTime.substring(11,16);
        String dataStr = dateTime.substring(0,10);
        DateTime now = new DateTime(new Date());
        String nowStr = now.toString(DATE_FORMAT);
        if(!nowStr.equals(dataStr)){
            return returnTime+"("+dataStr.substring(8,10)+")";
        }else{
            return returnTime;
        }

    }

    public static String timeDayFormatByStr2(String dateTime){
        if(dateTime == null || dateTime.equals("")){
            return StringUtils.EMPTY;
        }
        /*//返回时间格式：12:10+1或者12:10-1或者12:10，写法代码
        String returnTime = dateTime.substring(11,16);
        DateTimeFormatter dtf = DateTimeFormat.forPattern(DATE_FORMAT);
        String dataStr = dateTime.substring(0,10);
        LocalDate datePar = LocalDate.parse(dataStr, dtf);
        DateTime now = new DateTime(new Date());
        LocalDate nowDate = LocalDate.parse(now.toString(DATE_FORMAT), dtf);
        long timeLong = datePar.toDate().getTime();
        long nowLong  = nowDate.toDate().getTime();
        long daysBetween = (timeLong - nowLong) / (3600*24*1000);
        if(daysBetween != 0){
            if(daysBetween > 0){
                returnTime +=  "+"+daysBetween;
            }else{
                returnTime +=  daysBetween;
            }
        }
        */
        String returnTime = dateTime.substring(11,16);
        String dataStr = dateTime.substring(0,10);
        DateTime now = new DateTime(new Date());
        String nowStr = now.toString(DATE_FORMAT);

            return returnTime+"("+dataStr.substring(8,10)+")";


    }

    /**
     * 时间格式化
     * 返回时间格式：12:10(天数)
     * @param dateTime 时间字符串 2019-04-25 12:10:00
     * @return String 返回小时+分钟+天数
     */
    public static String reDayFormatByStr(String dateTime){
        if(dateTime == null || dateTime.equals("")){
            return StringUtils.EMPTY;
        }
        //返回时间格式：12:10+1或者12:10-1或者12:10，写法代码
        String returnTime = dateTime.substring(11,16);
        DateTimeFormatter dtf = DateTimeFormat.forPattern(DATE_FORMAT);
        String dataStr = dateTime.substring(0,10);
        LocalDate datePar = LocalDate.parse(dataStr, dtf);
        DateTime now = new DateTime(new Date());
        LocalDate nowDate = LocalDate.parse(now.toString(DATE_FORMAT), dtf);
        long timeLong = datePar.toDate().getTime();
        long nowLong  = nowDate.toDate().getTime();
        long daysBetween = (timeLong - nowLong) / (3600*24*1000);
        if(daysBetween != 0){
            if(daysBetween > 0){
                returnTime +=  "+"+daysBetween;
            }else{
                returnTime +=  daysBetween;
            }
        }
        return returnTime;

    }



    /**
     * 时间格式化
     * 返回时间格式：12:10(天数)
     * @param date 时间对象 2019-04-25 12:10:00
     * @return String 返回小时+分钟+天数
     */
    public static String timeDayFormatByDate(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dt = new DateTime(date);
        String dateTime = dt.toString(STANDARD_FORMAT);

        /*//返回时间格式：12:10+1或者12:10-1或者12:10, 写法代码
        String returnTime = dateTime.substring(11,16);
        DateTimeFormatter dtf = DateTimeFormat.forPattern(DATE_FORMAT);
        String dataStr = dateTime.substring(0,10);
        LocalDate datePar = LocalDate.parse(dataStr, dtf);
        DateTime now = new DateTime(new Date());
        LocalDate nowDate = LocalDate.parse(now.toString(DATE_FORMAT), dtf);
        long timeLong = datePar.toDate().getTime();
        long nowLong  = nowDate.toDate().getTime();
        long daysBetween = (timeLong - nowLong) / (3600*24*1000);
        if(daysBetween != 0){
            if(daysBetween > 0){
                returnTime +=  "+"+daysBetween;
            }else{
                returnTime +=  daysBetween;
            }
        }
        */
        String returnTime = dateTime.substring(11,16);
        String dataStr = dateTime.substring(0,10);
        DateTime now = new DateTime(new Date());
        String nowStr = now.toString(DATE_FORMAT);
        System.out.println("dataStr=="+dataStr);
        System.out.println("nowStr=="+nowStr);
        if(!nowStr.equals(dataStr)){
            return returnTime+"("+dataStr.substring(8,10)+")";
        }else{
            return returnTime;
        }
    }

    public static String timeDayFormatByDate2(Date date){
        if(date == null){
            return StringUtils.EMPTY;
        }
        DateTime dt = new DateTime(date);
        String dateTime = dt.toString(STANDARD_FORMAT);

        /*//返回时间格式：12:10+1或者12:10-1或者12:10, 写法代码
        String returnTime = dateTime.substring(11,16);
        DateTimeFormatter dtf = DateTimeFormat.forPattern(DATE_FORMAT);
        String dataStr = dateTime.substring(0,10);
        LocalDate datePar = LocalDate.parse(dataStr, dtf);
        DateTime now = new DateTime(new Date());
        LocalDate nowDate = LocalDate.parse(now.toString(DATE_FORMAT), dtf);
        long timeLong = datePar.toDate().getTime();
        long nowLong  = nowDate.toDate().getTime();
        long daysBetween = (timeLong - nowLong) / (3600*24*1000);
        if(daysBetween != 0){
            if(daysBetween > 0){
                returnTime +=  "+"+daysBetween;
            }else{
                returnTime +=  daysBetween;
            }
        }
        */
        String returnTime = dateTime.substring(11,16);
        String dataStr = dateTime.substring(0,10);
        DateTime now = new DateTime(new Date());
        String nowStr = now.toString(DATE_FORMAT);
        System.out.println("dataStr=="+dataStr);
        System.out.println("nowStr=="+nowStr);

            return returnTime+"("+dataStr.substring(8,10)+")";

    }

    /**
     * 指定日期加上天数后的日期
     * @param num 为增加的天数
     * @param newDate 创建时间
     * @param formatStr 时间格式字符串
     * @return
     * @throws ParseException
     */
    public static String plusDay(int num,String newDate,String formatStr) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date  currdate = format.parse(newDate);
        System.out.println("现在的日期是：" + currdate);
        Calendar ca = Calendar.getInstance();
        ca.setTime(currdate);
        ca.add(Calendar.DATE, num);// num为增加的天数，可以改变的
        currdate = ca.getTime();
        String enddate = format.format(currdate);
        System.out.println("增加天数以后的日期：" + enddate);
        return enddate;
    }

    /**
     * 指定日期加上小时数后的日期
     * @param num 为增加的小时数
     * @param newDate 创建时间
     * @return
     * @throws ParseException
     */
    public static Date plusHour(int num,Date newDate) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat(STANDARD_FORMAT);
        Date  currdate = newDate;
        System.out.println("现在的日期是：" + format.format(currdate));
        Calendar ca = Calendar.getInstance();
        ca.setTime(currdate);
        ca.add(Calendar.HOUR_OF_DAY, num);// num为增加的天数，可以改变的
        currdate = ca.getTime();
        String enddate = format.format(currdate);
        System.out.println(num+"增加小时数以后的日期：" + format.format(currdate));
        return currdate;
    }

    /**
     * 指定日期时间加上分钟数后的日期时间
     * @param num 为增加的分钟数
     * @param newDate 创建时间
     * @param formatStr 时间格式字符串
     * @return
     * @throws ParseException
     */
    public static String plusMinute(int num,String newDate,String formatStr) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat(formatStr);
        Date  currdate = format.parse(newDate);
        System.out.println("现在的日期时间是：" + currdate);
        Calendar ca = Calendar.getInstance();
        ca.setTime(currdate);
        ca.add(Calendar.MINUTE, num);// num为增加的分钟，可以改变的
        currdate = ca.getTime();
        String enddate = format.format(currdate);
        System.out.println("增加分钟以后的日期时间是：" + enddate);
        return enddate;
    }



}
