package com.shang.scheduled_demo;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")//定时任务锁,默认时间30S
public class ScheduledDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScheduledDemoApplication.class, args);
    }

}
