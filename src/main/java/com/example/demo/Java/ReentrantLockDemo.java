package com.example.demo.Java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zh
 * @date 2021-02-27 20:05
 **/

public class ReentrantLockDemo {

    public static final ReentrantLock reentrantLock = new ReentrantLock();


    public static void runThread(String name) {
        if (reentrantLock.tryLock()) {
            System.out.println(name + " get lock");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            reentrantLock.unlock();

            System.out.println();
        }

        reentrantLock.unlock();

    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            runThread("thread1");
        });

        Thread thread2 = new Thread(() -> {
            runThread("thread2");
        });

        thread1.start();
        thread2.start();

        System.out.println(reentrantLock.getHoldCount());

        System.out.println(1 << 1);


    }


}
