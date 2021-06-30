package com.example.demo.javaSomething.concurrentUtilDemo;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class SemaphoreTest {
    private static int count = 20;


    public static void main(String[] args) {

        diffThreadRelease();

    }

    public static void functionDemo() {
        ExecutorService executorService = Executors.newFixedThreadPool(count);

        //指定最多只能有五个线程同时执行
        Semaphore semaphore = new Semaphore(5);

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            final int no = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获得许可
                        semaphore.acquire();
                        System.out.println(no + ":号车可通行");
                        //模拟车辆通行耗时
                        Thread.sleep(random.nextInt(2000));
                        //释放许可
//                        System.out.println(no +":号车通行完毕 准备释放号码");
                        semaphore.release();
                        System.out.println(no + ":号车释放通行证");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        executorService.shutdown();
    }


    public static void diffThreadRelease() {
        Random random = new Random();
        Semaphore semaphore = new Semaphore(5);
        Thread one = new Thread(() -> {
            try {
                //获得许可
                semaphore.acquire();
                System.out.println(Thread.currentThread().getId() + ":号车可通行");
                //模拟车辆通行耗时
                Thread.sleep(random.nextInt(2000));
                //释放许可
//                        System.out.println(no +":号车通行完毕 准备释放号码");
//                semaphore.release();
                System.out.println(Thread.currentThread().getId() + ":号车释放通行证");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        Thread two = new Thread(() -> {
            try {
                //获得许可
//                semaphore.acquire();
//                System.out.println(Thread.currentThread().getId() + ":号车可通行");
//                System.out.println(Thread.currentThread().getId());
                //模拟车辆通行耗时
                Thread.sleep(random.nextInt(2000));
                Thread.sleep(random.nextInt(2000));
                //释放许可其他线程加的共享锁
                semaphore.release();
                System.out.println(Thread.currentThread().getId() + ":号车释放通行证");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        one.start();
        two.start();





    }
}
