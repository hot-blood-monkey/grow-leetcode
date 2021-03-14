package com.example.demo.Java;

/**
 * @author zh
 * @date 2021-02-27 15:54
 **/

public class ThreadSleepWait {


    public static void main(String[] args) {

        Thread th1 = new Thread(() -> {
            new Thread1().run();
        });
        th1.start();
        new Thread(() -> new Thread2().run()).start();


    }


    static class Thread1 implements Runnable {

        @Override
        public void run() {

            System.out.println("Thread1 start ...");

            synchronized (ThreadSleepWait.class) {
                System.out.println("Thread1 get lock");


                try {
                    System.out.println("Thread1 release lock");
                    ThreadSleepWait.class.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Thread1 end ...");
        }
    }


    static class Thread2 implements Runnable {


        @Override
        public void run() {

            System.out.println("Thread2 start ...");

            synchronized (ThreadSleepWait.class) {
                System.out.println("Thread2 get lock");


                try {

                    System.out.println("Thread2 sleep doing");
                    Thread.sleep(1000);

                    ThreadSleepWait.class.notifyAll();
                    System.out.println("Thread2 notifyAll");



                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


                System.out.println("Thread2 end ...");


            }

        }
    }




}
