package com.example.demo.javaSomething.concurrentUtilDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTestDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(6, () -> {
            try {
                Thread.sleep(500);

                System.out.println("restart " );
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Main " + Thread.currentThread().getId() +" start");

        for (int i = 0; i < 6; i++) {
            Thread thread = new Thread(() -> {
                try {
                    System.out.println("Thread " + Thread.currentThread().getId() +" start cyclicBarrier");
                    cyclicBarrier.await();
                    System.out.println("Thread " + Thread.currentThread().getId() +" end cyclicBarrier");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
        System.out.println("Main " + Thread.currentThread().getId() +" end");
    }
}
