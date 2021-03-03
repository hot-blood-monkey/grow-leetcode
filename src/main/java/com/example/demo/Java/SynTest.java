package com.example.demo.Java;

/**
 * @author zh
 * @date 2021-02-19 10:32
 **/

public class SynTest {

    static class SyncThread {

        public synchronized void run(String name) {
            System.out.println(name + " start");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " end");
        }

        public static synchronized void runStatic(String name) {
            System.out.println(name + " start");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " end");
        }

        public void run2(String name) {
            synchronized (this) {
                System.out.println(name + " start");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " end");
            }

        }

        public void run2Class(String name) {
            synchronized (SyncThread.class) {
                System.out.println(name + " start");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name + " end");
            }

        }
    }


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String name = String.valueOf(i);
            Thread thread = new Thread(() -> {
                SyncThread syncThread = new SyncThread();
                syncThread.run2Class(name);
//                SyncThread.runStatic(name);
            });
            thread.start();
        }


    }
}
