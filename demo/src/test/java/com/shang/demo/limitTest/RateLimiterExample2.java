package com.shang.demo.limitTest;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RateLimiterExample2 {
    private static RateLimiter rateLimiter = RateLimiter.create(10);

    public static void main(String[] args) throws Exception {
        for (int index = 0; index < 100; index++) {
            rateLimiter.acquire();
            handle(index);
        }
    }

    private static void handle(int i) {
        System.out.println(i);
    }
}
