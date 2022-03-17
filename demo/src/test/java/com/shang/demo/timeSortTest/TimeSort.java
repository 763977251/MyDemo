package com.shang.demo.timeSortTest;

import lombok.Data;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TimeSort {
    @Test
    public void test(){
        List<Appoint> list = new ArrayList<>();
        list.add(new Appoint(1L, DateUtil.parseDatetime("2022-03-01T03:00:00"),DateUtil.parseDatetime("2022-03-01T03:20:00")));
//        list.add(new Appoint(2L, DateUtil.parseDatetime("2022-03-01T03:10:00"),DateUtil.parseDatetime("2022-03-01T03:30:00")));
//        list.add(new Appoint(3L, DateUtil.parseDatetime("2022-03-01T03:10:00"),DateUtil.parseDatetime("2022-03-01T04:50:00")));
//        list.add(new Appoint(4L, DateUtil.parseDatetime("2022-03-01T04:10:00"),DateUtil.parseDatetime("2022-03-01T04:30:00")));
//        list.add(new Appoint(5L, DateUtil.parseDatetime("2022-03-01T04:30:00"),DateUtil.parseDatetime("2022-03-01T06:50:00")));
//        list.add(new Appoint(7L, DateUtil.parseDatetime("2022-03-01T06:30:00"),DateUtil.parseDatetime("2022-03-01T09:40:00")));
//        list.add(new Appoint(6L, DateUtil.parseDatetime("2022-03-01T09:10:00"),DateUtil.parseDatetime("2022-03-01T09:30:00")));

        List<Long> allIds = list.stream().map(Appoint::getId).collect(Collectors.toList());
        List<Long> endIds = new ArrayList<>();
        Date maxEndDate = DateUtil.parseDatetime("2022-03-01T01:00:00");
        Long maxEndDateId =  0L;
        for (int i = 0; i < list.size()-1; i++) {
            Appoint appoint = list.get(i);
            Appoint appoint1 = list.get(i + 1);

            Date endTime = appoint.getEndTime();
            if (maxEndDate.getTime()<endTime.getTime()){
                maxEndDate = endTime;
                maxEndDateId = appoint.getId();
            }
            Date startTime = appoint1.getStartTime();
            if (maxEndDate.getTime()<startTime.getTime()){
                endIds.add(appoint.getId());
            }
            if (i+2 == list.size()){  // 时间断开，且i是倒数第二个
                if (maxEndDate.getTime()<appoint1.getEndTime().getTime()) {
                    endIds.add(appoint1.getId());
                } else {
                    endIds.add(maxEndDateId);
                }
            }
        }

        System.out.println(endIds);
        allIds.removeAll(endIds);
        System.out.println(allIds);

    }

    @Data
    class Appoint{

        public Appoint(Long id, Date startTime, Date endTime) {
            this.id = id;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        private Long id;
        private Date startTime;
        private Date endTime;
    }
}
