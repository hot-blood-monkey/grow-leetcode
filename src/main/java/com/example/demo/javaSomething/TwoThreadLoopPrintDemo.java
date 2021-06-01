package com.example.demo.javaSomething;

/**
 * 两个线程循环打印
 */
public class TwoThreadLoopPrintDemo {


    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            while (true) {
                synchronized (SyncLock.class) {
                    if (SyncLock.getState() == 0) {
                        SyncLock.setLock(1);
                        System.out.println("a");
                    }
                }
            }
        });

        Thread b = new Thread(() -> {
            while (true) {
                synchronized (SyncLock.class) {
                    if (SyncLock.getState() == 1) {
                        SyncLock.setLock(0);
                        System.out.println("b");
                    }
                }
            }
        });

        a.start();
        b.start();


    }


}
