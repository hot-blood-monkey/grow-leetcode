package com.example.demo.javaSomething;

import org.apache.dubbo.common.utils.NamedThreadFactory;

import java.util.concurrent.*;

public class ThreadPoolExeDemo {
    public static final ThreadFactory threadFactory = new NamedThreadFactory("Thread-Pre-");
    public static final ExecutorService executor = new ThreadPoolExecutor(5, 10, 10L, TimeUnit.SECONDS,  new ArrayBlockingQueue(10), threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());

    public static void runFunc(int index) {
        System.out.println(Thread.currentThread().getName() + " index " + index);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " index " + index);
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int index = i;
            executor.submit(() -> runFunc(index));
        }
    }
}
