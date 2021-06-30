package com.example.demo.javaSomething.concurrentUtilDemo;

import org.apache.dubbo.common.utils.NamedThreadFactory;

import java.util.concurrent.*;

public class CountDownLatchDemo {
    public static final ThreadFactory threadFactory = new NamedThreadFactory("Thread-CountDownLatchDemo-");

    public static final ExecutorService executor = new ThreadPoolExecutor(10, 20, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue(10), threadFactory, new ThreadPoolExecutor.CallerRunsPolicy());
    public static CountDownLatch countDownLatch = new CountDownLatch(5);


    public static void carArrive(String name) {
        System.out.println( "Car " + name +" arrive");
        countDownLatch.countDown();
        System.out.println( "Car " + name +" arrive down");
    }

    public static void workerCanDo(String name)  {
        System.out.println("Worker" + name +" init ");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker" + name +" start work");
    }

    public static void main(String[] args) {
        executor.submit(() -> workerCanDo("1"));
        executor.submit(() -> workerCanDo("2"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 5; i++) {
            String s = String.valueOf(i);
            executor.submit(() -> carArrive(s));
        }
    }


}
