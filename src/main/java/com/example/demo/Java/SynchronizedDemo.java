package com.example.demo.Java;

import ch.qos.logback.core.util.TimeUtil;

import java.util.concurrent.*;

/**
 * @author zh
 * @date 2021-02-19 14:11
 **/

public class SynchronizedDemo {

//    public static ExecutorService executorService = new ThreadPoolExecutor(100, 200, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(), AbortPolicy);

    public static void main(String[] args) {
        synchronized (SynchronizedDemo.class) {
        }
        method();
    }

    private static void method() {
    }
}
