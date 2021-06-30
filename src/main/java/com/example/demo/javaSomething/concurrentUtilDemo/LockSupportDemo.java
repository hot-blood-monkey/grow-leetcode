package com.example.demo.javaSomething.concurrentUtilDemo;

import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void blockDemo() {
        Thread thread = new Thread(() -> {
            LockSupport.unpark(Thread.currentThread());
            System.out.println(Thread.currentThread() + " park before ... ");
            LockSupport.park(Thread.currentThread());
            System.out.println(Thread.currentThread() + " park after ... ");
            System.out.println(Thread.currentThread() + " second park before ... ");
            LockSupport.park(Thread.currentThread());
            System.out.println(Thread.currentThread() + " second park after...");

        });

        thread.start();

        try {
            Thread.sleep(2000);
            System.out.println(Thread.currentThread() + " sleep done ...");
            System.out.println(Thread.currentThread() + " unPark " + thread + " ...");
            LockSupport.unpark(thread);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        blockDemo();
    }

}
