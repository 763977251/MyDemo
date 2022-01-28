package com.shang.demo.dateTest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class DateTest {
    public static void main(String[] args) {
        Map<String, Object> dates = new HashMap<>();
        dates.put("start", LocalDate.now().toString());
        dates.put("end", LocalDate.now().plusDays(1).toString());
        System.out.println(dates);
    }
}
