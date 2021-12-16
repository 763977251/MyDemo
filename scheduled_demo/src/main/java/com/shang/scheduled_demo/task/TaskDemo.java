package com.shang.scheduled_demo.task;

import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TaskDemo {

    @Scheduled(cron="0 */1 * * * *") //每分钟执行一次
    @SchedulerLock(name = "test", lockAtMostFor = "50s", lockAtLeastFor = "40s") // 锁最多保持50秒，最少保持40秒
    public void test(){
        Date now = new Date();
        System.out.println("定时任务开始执行，时间：" + now);

    }
}
