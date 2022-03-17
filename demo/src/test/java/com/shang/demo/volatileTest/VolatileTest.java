package com.shang.demo.volatileTest;

public class VolatileTest {
    private static volatile int count = 0;

    private synchronized static void increase() {
        count++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            }).start();
        }
        // 所有线程累加完成后输出
        while (Thread.activeCount() > 2) Thread.yield();
        System.out.println(count);
    }
}

