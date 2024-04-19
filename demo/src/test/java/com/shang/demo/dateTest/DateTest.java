package com.shang.demo.dateTest;

import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateTest {
    public static void main(String[] args) {
        Map<String, Object> dates = new HashMap<>();
        dates.put("start", LocalDate.now().toString());
        dates.put("end", LocalDate.now().plusDays(1).toString());
        System.out.println(dates);
    }

    @Test
    public void test() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date today = calendar.getTime();
        System.out.println("today=" + today);
        Date startDay = DateUtil.parseDatetime("2021-08-18T00:00:00");
        int days = differentDaysByMillisecond(startDay, today);
        System.out.println("days=" + days);
        Integer intervalDays = 7;
        int times = days / intervalDays;  // 第几次
        System.out.println("times=" + times);
        int addDays = times * intervalDays;
        if (addDays < days){
            addDays += intervalDays;
        }
        System.out.println("addDays=" + addDays);
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(startDay);
        calendar1.add(Calendar.DAY_OF_YEAR, addDays);
        Date time = calendar1.getTime();
        System.out.println("time="+time);
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @param before
     * @param after
     * @return
     */
    public static int differentDaysByMillisecond(Date before, Date after) {
        int days = (int) ((after.getTime() - before.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    @Test
    public void test1(){
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(new Date());
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        Date today = calendar.getTime();
        Date today = DateUtil.parseDatetime("2022-03-16T00:00:00");
        System.out.println("today=" + today);
        Date startDay = DateUtil.parseDatetime("2022-01-30T00:00:00");
        int months = getDistanceMonth(startDay, today);
        System.out.println("months="+months);
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDay);
        cal.add(Calendar.MONTH, months);
        Date time = cal.getTime();
        if (time.getTime() < today.getTime()){
            cal.add(Calendar.MONTH, 1);
            time = cal.getTime();
        }
        System.out.println("time="+time);
    }

    public static int getDistanceMonth(Date before, Date after){
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(before);
        aft.setTime(after);
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        return Math.abs(month + result);
    }

    @Test
    public void testIsSameDay(){
        Date today = DateUtil.parseDatetime("2022-03-16T00:00:00");
        Date startDay = DateUtil.parseDatetime("2022-03-16T19:00:00");
        System.out.println(cn.hutool.core.date.DateUtil.isSameDay(startDay, today));
    }

    @Test
    public void testFormat() throws ParseException {
        String time = "2024/8/7 0:00:00.0";
//        String time = "2024/8/23";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date parse = sdf.parse(time);
        System.out.println(parse);
    }

    @Test
    public void test1212(){
        int hour = LocalDateTime.now().getHour();
        System.out.println(hour);
        LocalDate localDate = LocalDate.now().plusDays(-1);
        System.out.println(localDate.toString());

        Integer time = 23;
        LocalDateTime start;
        LocalDateTime end;
        if (time < 8){
            start = LocalDateTime.of(localDate, LocalTime.MIN).plusDays(1).plusHours(time);
            end = LocalDateTime.of(localDate, LocalTime.MIN).plusDays(1).plusHours(time+1);
        } else {
            start = LocalDateTime.of(localDate, LocalTime.MIN).plusHours(time);
            end = LocalDateTime.of(localDate, LocalTime.MIN).plusHours(time+1);
        }
        System.out.println(start.isAfter(end));
        System.out.println(end.getMinute());
    }

}
