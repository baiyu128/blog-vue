package cn.baiyu.common.utils;


import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DateUtil {
//    private static Log log = LogFactory.getLog(DateUtil.class);

    private static String datePattern = "yyyy-MM-dd";

    private static String timePattern = "HH:mm:ss";


    public static long getSecondTime(Date date) {
        long l = date.getTime() / 1000;
        return l;
    }

    /**
     * 获得当前月的开始时间
     * @return
     */
    public static String getThisMonthStart(){
        Calendar c = Calendar.getInstance();
        c.add(c.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,1);
        c.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH), 0, 0, 0);
        return DateUtil.getDateStr(c.getTime());
    }

    /**
     * 获得当前的结束时间
     * @return
     */
    public static String getThisMonthEnd(){
        Calendar c = Calendar.getInstance();
        c.add(c.MONTH, 1);
        c.set(Calendar.DAY_OF_MONTH,0);
        c.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH), 23, 59, 59);
        return DateUtil.getDateStr(c.getTime());
    }

    /**
     * 获得前一个月的开始时间
     * @return
     */
    public static String getPreMonthStart(){
        Calendar c = Calendar.getInstance();
        c.add(c.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH,1);
        c.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH), 0, 0, 0);
        return DateUtil.getDateStr(c.getTime());
    }

    /**
     * 获得前一个月的结束时间
     * @return
     */
    public static String getPreMonthEnd(){
        Calendar c = Calendar.getInstance();
        c.add(c.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH,0);
        c.set(c.get(c.YEAR), c.get(c.MONTH), c.get(c.DAY_OF_MONTH), 23, 59, 59);
        return DateUtil.getDateStr(c.getTime());
    }


    /**
     * 把传入的日期字符串，转换成指定格式的日期对象
     *
     * @param dateString 日期字符串
     * @param pattern    指定转换格式
     * @return 日期对象
     */
    public static Long getDateTime(String dateString, String pattern) {
        Long time = null;
        if (dateString != null) {
            try {
                SimpleDateFormat df = new SimpleDateFormat(pattern);
                Date date = df.parse(dateString);
                time = date.getTime();
            } catch (Exception e) {
            }
        }
        return time;
    }

    /**
     * 获取当前 时间 精确到秒
     *
     * @return
     */
    public static Date getNowDateToSec() {
        Date date = new Date();
        SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
        try {
            return sdff.parse(sdff.format(date));
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取当前 时间 精确到秒
     *
     * @return
     */
    public static Long getTimeByStringDate(String date, String pattern) {
        SimpleDateFormat sdff = new SimpleDateFormat(pattern);
        try {
            return sdff.parse(date).getTime();
        } catch (ParseException e) {
            return 0L;
        }
    }

    /**
     * date转成yyyy-MM-dd HH:mm:ss 格式
     *
     * @param date
     * @return
     */
    public static String getDateStr(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdff = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是你要转成后的时间的格式
        String time = sdff.format(date);
        return time;
    }

    /**
     * Return 缺省的日期格式 (yyyy/MM/dd)
     *
     * @return 在页面中显示的日期格式
     */
    public static String getDatePattern() {
        return datePattern;
    }

    /**
     * 根据日期格式，返回日期按datePattern格式转换后的字符串
     *
     * @param aDate 日期对象
     * @return 格式化后的日期的页面显示字符串
     */
    public static final String getDate(Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (aDate != null) {
            df = new SimpleDateFormat(datePattern);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }

    /**
     * 根据日期格式，返回日期指定格式转换后的字符串
     *
     * @param date 日期对象
     * @return 格式化后的日期字符串
     */
    public static String getDateTime(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(datePattern);
        if (date == null) return "";
        df.applyPattern("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }

    /**
     * 根据日期格式，返回当前日期指定格式转换后的字符串
     *
     * @param pattern 指定转换格式
     * @return 格式化后的日期字符串
     */
    public static final String getDate(String pattern) {
        Date date = new Date();
        return getDate(date, pattern);
    }

    /**
     * 根据日期格式，返回指定日期指定格式转换后的字符串
     *
     * @param date    日期对象
     * @param pattern 指定转换格式
     * @return 格式化后的日期字符串
     */
    public static final String getDate(Date date, String pattern) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (date != null) {
            df = new SimpleDateFormat(pattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

    /**
     * 把传入的日期字符串，转换成指定格式的日期对象
     *
     * @param dateString 日期字符串
     * @param pattern    指定转换格式
     * @return 日期对象
     */
    public static Date getDate(String dateString, String pattern) {
        SimpleDateFormat df = null;
        Date date = new Date();
        if (dateString != null) {
            try {
                df = new SimpleDateFormat(pattern);
                date = df.parse(dateString);
            } catch (Exception e) {
            }
        }
        return date;
    }


    /**
     * 获取传入日期的年月
     *
     * @param date 传入的日期
     * @return 日期年月字符串
     */
    public static String getMonth(Date date) {
        SimpleDateFormat df = null;
        if (date != null) {
            df = new SimpleDateFormat();
            df.applyPattern("yyyy-MM");
            return df.format(date);
        }
        return null;
    }

    /**
     * 获取传入日期的时分秒
     *
     * @param date 传入的日期
     * @return 时分秒字符串
     */
    public static String getTime(Date date) {
        SimpleDateFormat df = null;
        if (date != null) {
            df = new SimpleDateFormat();
            df.applyPattern("HH:mm:ss");
            return df.format(date);
        }
        return null;
    }

    /**
     * 按照日期格式，将字符串解析为日期对象
     *
     * @param aMask   输入字符串的格式
     * @param strDate 一个按aMask格式排列的日期的字符串描述
     * @return Date 对象
     * @throws ParseException
     * @see SimpleDateFormat
     */
    public static final Date convertStringToDate(String aMask, String strDate) {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(aMask);
//        if (log.isDebugEnabled())
//        {
//            log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
//        }
        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
        }
        return (date);
    }

    /**
     * This method returns the current date time in the format: yyyy/MM/dd HH:MM
     * a
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(timePattern, theTime);
    }

    /**
     * This method returns the current date in the format: yyyy/MM/dd
     *
     * @return the current date
     * @throws ParseException
     */
    public static Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(datePattern);
        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));
        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time in
     * the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * @see SimpleDateFormat
     */
    public static final String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";
        if (aDate == null) {
//            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }
        return (returnValue);
    }

    /**
     * 根据日期格式，返回日期按datePattern格式转换后的字符串
     *
     * @param aDate Date
     * @return String
     */
    public static final String convertDateToString(Date aDate) {
        return getDateTime(datePattern, aDate);
    }

    /**
     * 按照日期格式，将字符串解析为日期对象
     *
     * @param strDate String
     * @return Date
     * @throws ParseException
     */
    public static Date convertStringToDate(String strDate) {
        Date aDate = null;
//        if (log.isDebugEnabled())
//        {
//            log.debug("converting date with pattern: " + datePattern);
//        }
        aDate = convertStringToDate(datePattern, strDate);
        return aDate;
    }

    public static String getYear() {
        Date date = new Date();
        return getDate(date, "yyyy");
    }

    public static String getMonth() {
        Date date = new Date();
        return getDate(date, "MM");
    }

    public static String getDay() {
        Date date = new Date();
        return getDate(date, "dd");
    }

    /**
     * 获取当前时间的小时
     *
     * @return 返回小时
     */
    public static int getHour() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取当前时间的分钟
     *
     * @return 返回分钟
     */
    public static int getMinute() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 获取当前时间的秒钟
     *
     * @return 返回秒钟
     */
    public static int getSecond() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

    /**
     * 获取当前时间的毫秒
     *
     * @return 返回毫秒
     */
    public static long getMillis() {
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 返回小时
     *
     * @param date 日期
     * @return 返回小时
     */
    public static int getHour(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回分钟
     *
     * @param date 日期
     * @return 返回分钟
     */
    public static int getMinute(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.MINUTE);
    }

    /**
     * 返回秒钟
     *
     * @param date 日期
     * @return 返回秒钟
     */
    public static int getSecond(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(Calendar.SECOND);
    }

    /**
     * 返回毫秒
     *
     * @param date 日期
     * @return 返回毫秒
     */
    public static long getMillis(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }

    /**
     * 日期相加
     *
     * @param date 日期
     * @param day  天数
     * @return 返回相加后的日期
     */
    public static Date addDate(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
        return c.getTime();
    }

    /**
     * 日期相减
     *
     * @param date  日期
     * @param date1 日期
     * @return 返回相减后的日期
     */
    public static int diffDate(Date date, Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (24 * 3600 * 1000));
    }

    public static int diffDateToHour(Date date, Date date1) {
        return (int) ((getMillis(date) - getMillis(date1)) / (1000 * 60 * 60));
    }

    public static long diffDateToMillis(Date date, Date date1) {
        return (long) ((getMillis(date) - getMillis(date1)));
    }

    /**
     * 判断是否在一个时间段内
     *
     * @param time
     * @param begin
     * @param end
     * @return
     */
    public static boolean IsTimeIn(Date time, Date begin, Date end) {
        return time.getTime() >= begin.getTime() && time.getTime() <= end.getTime();
    }

    /**
     * 判断输入的时间是否今年
     *
     * @param time
     * @return true：今年，false：不是今年
     */
    public static boolean isThisYear(String time) {
        int timeYear = Integer.parseInt(time.substring(0, 4));
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int thisYear = calendar.get(Calendar.YEAR);
        if (timeYear == thisYear) {
            return true;
        } else {
            return false;
        }
    }

    public static String getLastMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);    //得到前一天
        calendar.add(Calendar.MONTH, -1);    //得到前一个月
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;

        String data = "" + year;
        if (month < 10) {
            data += "0" + month;
        } else {
            data += "" + month;
        }

        return data;
    }

    /**
     * 日期加减操作
     *
     * @param source 源日期
     * @param num    推迟天数 + 为往后 - 为往前
     * @return
     */
    public static String dateRoler(Date source, int num) {
        try {
            Calendar c = Calendar.getInstance();
            c.setTime(source);
            c.add(c.DAY_OF_MONTH, num);
            return getDate(c.getTime());
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 计算两日期之间相差的天数 day1 -day2
     *
     * @param day1
     * @param day2
     * @return
     * @throws ParseException
     */
    public static int countDays(String day1, String day2)
            throws ParseException {

        if (day1 != null && day2 != null && day1.length() > 0
                && day2.length() > 0) {
            // 日期相减算出秒的算法
            Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(day1);
            Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(day2);
            // 日期相减得到相差的日期
            long day = (date1.getTime() - date2.getTime())
                    / (24 * 60 * 60 * 1000);
            return (int) day;
        } else {
            return 0;
        }

    }


    /**
     * 计算两日期之间相差的天数 day1-day2
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int countDays(Date date1, Date date2) {
        if (date1 == null || date2 == null) return 0;
        long day = (date1.getTime() - date2.getTime())
                / (24 * 60 * 60 * 1000);
        return (int) day;
    }

    /**
     * 判断当前日期是星期几
     *
     * @param dateTimeStr 要判断的时间
     * @return dayForWeek 判断结果
     */
    public static int dayForWeek(String dateTimeStr) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(dateTimeStr));
        int dayForWeek = 0;
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            dayForWeek = 7;
        } else {
            dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
        }
        return dayForWeek;
    }


    /**
     * 获取某日期所在周的星期天日期(以周一为一周的第一天)
     *
     * @param dateTimeStr
     * @return String 返回日期
     */
    public static String getDataForSunday(String dateTimeStr)
            throws Exception {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(dateTimeStr));
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
        return df.format(c.getTime());
    }

    /**
     * 获取某日期是一年中的第几周
     *
     * @param dateTimeStr
     * @return int
     */
    public static int getWeekOfYear(String dateTimeStr) throws Exception {
        SimpleDateFormat df = new SimpleDateFormat();
        df.applyPattern("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(df.parse(dateTimeStr));
        c.setFirstDayOfWeek(Calendar.MONDAY);
        return c.get(Calendar.WEEK_OF_YEAR);
    }


    /**
     * 时间前推或后推分钟,其中JJ表示分钟. +后推 -前推
     */
    public static String getPreTime(String sj1, Integer jj) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String mydate1 = "";
        try {
            Date date1 = format.parse(sj1);
            long Time = (date1.getTime() / 1000) + jj * 60;
            date1.setTime(Time * 1000);
            mydate1 = format.format(date1);
        } catch (Exception e) {
        }
        return mydate1;
    }


    /**
     * 判断时间date1是否在时间date2之前
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isDateBefore(String date1, String date2) {
        try {
            DateFormat df = DateFormat.getDateTimeInstance();
            return df.parse(date1).before(df.parse(date2));
        } catch (ParseException e) {
            return false;
        }
    }

    /**
     * 功能:   判断是否是月末
     *
     * @param 日期
     * @return true月末, false不是月末
     */
    public static boolean isYueMo(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.DATE) == calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
            return true;
        else
            return false;
    }

    /**
     * 功能:   判断是否当月
     *
     * @param 日期
     * @return 是返回true，否返回false
     */
    public static boolean isDangYue(String dateStr) {
        String str = dateStr.substring(5, 7);
        Calendar calendar = Calendar.getInstance();
        String cm = "";
        if (calendar.get(Calendar.MONTH) + 1 <= 9) {
            cm = "0" + (calendar.get(Calendar.MONTH) + 1);
        } else {
            cm = (calendar.get(Calendar.MONTH) + 1) + "";
        }
        if (cm.equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获得当前日期的前N天或后N天
     *
     * @param day 整数是前推N天（即过去某一天），负数是向后推N天（即将来某一天）
     * @return
     * @throws Exception
     */
    public static String getSpecifiedDayBeforeOrAfter(int oper) {
        Calendar c = Calendar.getInstance();
        Date date = new Date();
        c.setTime(date);
        int day = c.get(Calendar.DATE);
        c.set(Calendar.DATE, day - oper);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
                .getTime());
        return dayBefore;
    }

    /**
     * 取得当月天数
     */
    public static int getCurrentMonthDays() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);//把日期设置为当月第一天
        cal.roll(Calendar.DATE, -1);//日期回滚一天，也就是最后一天
        int maxDate = cal.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 取得本日是本月的第几天
     */
    public static int getCurrentDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        int num = cal.get(Calendar.DAY_OF_MONTH);
        return num;
    }

    public static long getTodayZeroSeconds() {
        long current = System.currentTimeMillis();// 当前时间毫秒数
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long todayzero = calendar.getTimeInMillis();
        long todayzeroSeconds = (current - todayzero) / 1000;
        return todayzeroSeconds;
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param timeStamp 精确到秒的字符串
     * @return
     */
    public static String timeStamp2Date(Long timeStamp) {
        if (timeStamp == null || timeStamp.equals("null")) {
            return "";
        }
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(timeStamp));
    }

    /**
     * 时间戳转换成日期格式字符串
     *
     * @param dateStr 精确到秒的字符串
     * @return
     */
    public static Date str2Date(String dateStr) {
        try {
            if (StringUtils.isEmpty(dateStr))
                return null;
            String format = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     *
     * @param dateStr
     * @param pattern
     * @return
     */
    public static String str2DateStr(String dateStr, String pattern) {
        try {
            if (StringUtils.isEmpty(dateStr))
                return null;
            String format = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            Date parse = sdf.parse(dateStr);
            return getDate(parse,pattern);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 日期转成字符串
     *
     * @param date
     * @return
     */
    public static String date2str(Date date) {
        if (date == null)
            return null;
        String format = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 时间增加几个月
     * @param date
     * @param monCnt
     * @return
     * @throws ParseException
     */
    public static String addMonth(String date,Integer monCnt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, monCnt);
        Date dt1 = rightNow.getTime();
        String reStr = sdf.format(dt1);
        return reStr;
    }

    /**
     * 计算停车时间
     * @param inTime
     * @param outTime
     * @return
     */
    public static String calStayTime(String inTime,String outTime){
        int time = 0;
        if (StringUtils.isEmpty(inTime) || StringUtils.isEmpty(outTime) ){
            return secondToTime(time);
        }
        Date in = str2Date(inTime);
        Date out = str2Date(outTime);
        long l = out.getTime() - in.getTime();
        if (l < 0){

        }else {
            time = (int) (l /1000);
        }
        return secondToTime(time);
    }

    /**
     * 计算停车分钟
     * @param inTime
     * @param outTime
     * @return
     */
    public static Integer calMinute(String inTime,String outTime){
        int time = 0;
        if (StringUtils.isEmpty(inTime) || StringUtils.isEmpty(outTime) ){
            return time;
        }
        Date in = str2Date(inTime);
        Date out = str2Date(outTime);
        long l = out.getTime() - in.getTime();
        if (l < 0){

        }else {
            time = (int) (l / (1000 * 60));
        }
        return time;
    }

    /**
     * 计算停车分钟
     * @param inTime
     * @param outTime
     * @return
     */
    public static Long calSecond(String inTime,String outTime){
        long time = 0;
        if (StringUtils.isEmpty(inTime) || StringUtils.isEmpty(outTime) ){
            return time;
        }
        Date in = str2Date(inTime);
        Date out = str2Date(outTime);
        long l = out.getTime() - in.getTime();
        if (l > 0){
            time = l / 1000;
        }
        return time;
    }

    /**
     * 返回日时分秒
     * @param second
     * @return
     */
    public static String secondToTime(Integer second) {
        if (second < 0) return "-1";
        Integer days = second / 86400;//转换天数
        second = second % 86400;//剩余秒数
        Integer hours = second / 3600;//转换小时数
        second = second % 3600;//剩余秒数
        Integer minutes = second / 60;//转换分钟
        second = second % 60;//剩余秒数
        if (0 < days){
            return days + "天"+hours+"小时"+minutes+"分"+second+"秒";
        }else {
            return hours+"小时"+minutes+"分"+second+"秒";
        }
    }

}

