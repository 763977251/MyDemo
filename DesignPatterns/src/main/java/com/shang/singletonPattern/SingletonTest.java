package com.shang.singletonPattern;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * @author 10699518
 */
public class SingletonTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(SingletonTest.class);

    private static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 20, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>(), new BasicThreadFactory.Builder().namingPattern("test").build(), new ThreadPoolExecutor.DiscardPolicy());

    public static void main(String[] args) {
        int count = 10;
        for (int i = 0; i < count; i++) {
            THREAD_POOL_EXECUTOR.execute(() -> LOGGER.info(Singleton.getInstance().toString()));
        }
    }
}
