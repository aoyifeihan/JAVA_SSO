package com.sso.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;


public class DateUtils {
    
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String MONTH_PATTERN = "yyyy-MM";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String MINUTE_ONLY_PATTERN = "mm";
    public static final String HOUR_ONLY_PATTERN = "HH";
    
    /**
     * ������Ӽ�����
     * @param date ���ΪNull����Ϊ��ǰʱ��
     * @param days �Ӽ�����
     * @param includeTime �Ƿ����ʱ����,true��ʾ����
     * @return
     * @throws ParseException 
     */
    public static Date dateAdd(Date date, int days, boolean includeTime) throws ParseException{
        if(date == null){
            date = new Date();
        }
        if(!includeTime){
            SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DATE_PATTERN);
            date = sdf.parse(sdf.format(date));
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
    
    /**
     * ʱ���ʽ�����ַ���
     * @param date Date
     * @param pattern StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN�� ���Ϊ�գ���Ϊyyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static String dateFormat(Date date, String pattern) throws ParseException{
        if(StringUtils.isBlank(pattern)){
            pattern = DateUtils.DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
    
    /**
     * �ַ���������ʱ�����
     * @param dateTimeString String
     * @param pattern StrUtils.DATE_TIME_PATTERN || StrUtils.DATE_PATTERN�����Ϊ�գ���Ϊyyyy-MM-dd
     * @return
     * @throws ParseException
     */
    public static Date dateParse(String dateTimeString, String pattern) throws ParseException{
        if(StringUtils.isBlank(pattern)){
            pattern = DateUtils.DATE_PATTERN;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.parse(dateTimeString);
    }
    
    /**
     * ������ʱ���ʽ��ֻ�����ڵ��ַ���������ֱ��ʹ��dateFormat��PatternΪNull���и�ʽ����
     * @param dateTime Date
     * @return
     * @throws ParseException
     */
    public static String dateTimeToDateString(Date dateTime) throws ParseException{
        String dateTimeString = DateUtils.dateFormat(dateTime, DateUtils.DATE_TIME_PATTERN);  
        return dateTimeString.substring(0, 10); 
    }
    
    /**
     * ��ʱ���֡���Ϊ00:00:00ʱ��������ʱ���ʽ��ֻ�����ڵ��ַ�����
     * ��ʱ���֡��벻Ϊ00:00:00ʱ��ֱ�ӷ���
     * @param dateTime Date
     * @return
     * @throws ParseException
     */
    public static String dateTimeToDateStringIfTimeEndZero(Date dateTime) throws ParseException{
        String dateTimeString = DateUtils.dateFormat(dateTime, DateUtils.DATE_TIME_PATTERN);
        if(dateTimeString.endsWith("00:00:00")){
            return dateTimeString.substring(0, 10);
        }else{
            return dateTimeString;
        }
    }
    
    /**
     * ������ʱ���ʽ�����ڶ��󣬺�dateParse����
     * @param dateTime Date
     * @return Date
     * @throws ParseException
     */
    public static Date dateTimeToDate(Date dateTime) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    
    /** 
     * ʱ��Ӽ�Сʱ
     * @param startDate Ҫ������ʱ�䣬Null��Ϊ��ǰʱ�� 
     * @param hours �Ӽ���Сʱ 
     * @return Date 
     */  
    public static Date dateAddHours(Date startDate, int hours) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.HOUR, c.get(Calendar.HOUR) + hours);  
        return c.getTime();  
    }
    
    /**
     * ʱ��Ӽ�����
     * @param startDate Ҫ������ʱ�䣬Null��Ϊ��ǰʱ�� 
     * @param minutes �Ӽ��ķ���
     * @return
     */
    public static Date dateAddMinutes(Date startDate, int minutes) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.MINUTE, c.get(Calendar.MINUTE) + minutes);  
        return c.getTime();  
    }
    
    /**
     * ʱ��Ӽ�����
     * @param startDate Ҫ������ʱ�䣬Null��Ϊ��ǰʱ�� 
     * @param minutes �Ӽ�������
     * @return
     */
    public static Date dateAddSeconds(Date startDate, int seconds) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.SECOND, c.get(Calendar.SECOND) + seconds);  
        return c.getTime();  
    }

    /** 
     * ʱ��Ӽ����� 
     * @param startDate Ҫ������ʱ�䣬Null��Ϊ��ǰʱ�� 
     * @param days �Ӽ������� 
     * @return Date 
     */  
    public static Date dateAddDays(Date startDate, int days) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.DATE, c.get(Calendar.DATE) + days);  
        return c.getTime();  
    }
    
    /** 
     * ʱ��Ӽ�����
     * @param startDate Ҫ������ʱ�䣬Null��Ϊ��ǰʱ�� 
     * @param months �Ӽ������� 
     * @return Date 
     */  
    public static Date dateAddMonths(Date startDate, int months) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + months);  
        return c.getTime();  
    }
    
    /** 
     * ʱ��Ӽ�����
     * @param startDate Ҫ������ʱ�䣬Null��Ϊ��ǰʱ�� 
     * @param years �Ӽ������� 
     * @return Date 
     */  
    public static Date dateAddYears(Date startDate, int years) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.YEAR, c.get(Calendar.YEAR) + years);  
        return c.getTime();  
    }  
    
    /** 
     * ʱ��Ƚϣ����myDate>compareDate����1��<����-1����ȷ���0�� 
     * @param myDate ʱ�� 
     * @param compareDate Ҫ�Ƚϵ�ʱ�� 
     * @return int 
     */  
    public static int dateCompare(Date myDate, Date compareDate) {  
        Calendar myCal = Calendar.getInstance();  
        Calendar compareCal = Calendar.getInstance();  
        myCal.setTime(myDate);  
        compareCal.setTime(compareDate);  
        return myCal.compareTo(compareCal);  
    }
    
    /**
     * ��ȡ����ʱ������С��һ��ʱ��
     * @param date
     * @param compareDate
     * @return
     */
    public static Date dateMin(Date date, Date compareDate) {
        if(date == null){
            return compareDate;
        }
        if(compareDate == null){
            return date;
        }
        if(1 == dateCompare(date, compareDate)){
            return compareDate;
        }else if(-1 == dateCompare(date, compareDate)){
            return date;
        }
        return date;  
    }
    
    /**
     * ��ȡ����ʱ��������һ��ʱ��
     * @param date
     * @param compareDate
     * @return
     */
    public static Date dateMax(Date date, Date compareDate) {
        if(date == null){
            return compareDate;
        }
        if(compareDate == null){
            return date;
        }
        if(1 == dateCompare(date, compareDate)){
            return date;
        }else if(-1 == dateCompare(date, compareDate)){
            return compareDate;
        }
        return date;  
    }
    
    /**
     * ��ȡ�������ڣ�����ʱ���룩��������������������
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException 
     */
    public static int dateBetween(Date startDate, Date endDate) throws ParseException {
        Date dateStart = dateParse(dateFormat(startDate, DATE_PATTERN), DATE_PATTERN);
        Date dateEnd = dateParse(dateFormat(endDate, DATE_PATTERN), DATE_PATTERN);
        return (int) ((dateEnd.getTime() - dateStart.getTime())/1000/60/60/24); 
    }
    
    /**
     * ��ȡ�������ڣ�����ʱ���룩������������������
     * @param startDate
     * @param endDate
     * @return
     * @throws ParseException 
     */
    public static int dateBetweenIncludeToday(Date startDate, Date endDate) throws ParseException {  
        return dateBetween(startDate, endDate) + 1;
    }
    
    /**
     * ��ȡ����ʱ�����ݣ���2017-02-13������2017
     * @param date
     * @return
     */
    public static int getYear(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }
    
    /**
     * ��ȡ����ʱ����·ݣ���2017��2��13�գ�����2
     * @param date
     * @return
     */
    public static int getMonth(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }
    
    /**
     * ��ȡ����ʱ��ĵڼ��죨���������ڵ�dd������2017-02-13������13
     * @param date
     * @return
     */
    public static int getDate(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        return cal.get(Calendar.DATE);
    }
    
    /**
     * ��ȡ����ʱ�䵱�µ�����������2017-02-13������28
     * @param date
     * @return
     */
    public static int getDaysOfMonth(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DATE);
    }
    
    /**
     * ��ȡ����ʱ�䵱�������������2017-02-13������2017���������
     * @param date
     * @return
     */
    public static int getDaysOfYear(Date date) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }
    
    /**
     * ����ʱ���ȡ������������
     * <li>2017-02-13������2017-02-28</li>
     * <li>2016-02-13������2016-02-29</li>
     * <li>2016-01-11������2016-01-31</li>
     * @param date Date
     * @return
     * @throws Exception 
     */
    public static Date maxDateOfMonth(Date date) throws Exception {
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        int value = cal.getActualMaximum(Calendar.DATE);
        return dateParse(dateFormat(date, MONTH_PATTERN) + "-" + value, null);
    }
    
    /**
     * ����ʱ���ȡ������С�����ڣ�Ҳ���Ƿ��ص��µ�1�����ڶ���
     * @param date Date
     * @return
     * @throws Exception 
     */
    public static Date minDateOfMonth(Date date) throws Exception {
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date);
        int value = cal.getActualMinimum(Calendar.DATE);
        return dateParse(dateFormat(date, MONTH_PATTERN) + "-" + value, null);
    }
    
    public static void main(String[] args) throws Exception {
        /*System.out.println(dateTimeToDate(new Date()));
        System.out.println(dateParse("2017-02-04 14:58:20", null));
        System.out.println(dateTimeToDateStringIfTimeEndZero(new Date()));
        System.out.println(dateTimeToDateStringIfTimeEndZero(dateTimeToDate(new Date())));*/
        //System.out.println(dateBetween(dateParse("2017-01-30", null), dateParse("2017-02-01", null)));
        //System.out.println(dateBetweenIncludeToday(dateParse("2017-01-30", null), dateParse("2017-02-01", null)));
        System.out.println(getDate(dateParse("2017-01-17", null)));
        /*
        System.out.println(getDaysOfMonth(dateParse("2017-02-01", null)));
        System.out.println(getDaysOfYear(dateParse("2017-01-30", null)));*/
        //System.out.println(dateFormat(dateAddMonths(dateParse("2017-02-07", StrUtils.MONTH_PATTERN), -12), StrUtils.MONTH_PATTERN));
        /*System.out.println(dateFormat(maxDateOfMonth(dateParse("2016-02", "yyyy-MM")), null));
        System.out.println(dateFormat(minDateOfMonth(dateParse("2016-03-31", null)), null));*/
    }
    
    
}