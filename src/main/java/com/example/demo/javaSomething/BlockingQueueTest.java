package com.example.demo.javaSomething;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zh
 * @date 2021-03-15 11:42
 **/

public class BlockingQueueTest {

    public static final ReentrantLock lock = new ReentrantLock();
    public static final Condition putCon = lock.newCondition();
    public static final Condition getCon = lock.newCondition();
    public static final ExecutorService executorService = new ThreadPoolExecutor(10, 20, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());


    public static void testArrayBlockingQueue() {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(5);
        queue.offer(1);
        queue.offer(1);
        queue.offer(3);
        queue.offer(2);

        queue.remove(1);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

    public void runTask(String name) {
        System.out.println(name + " start ...");
        try {
            lock.lock();

            System.out.println("runTask " + name + " get lock ...");
            System.out.println("runTask " + name + " get await ...");
            putCon.await();
            System.out.println("runTask " + name + " await done ...");
            Thread.sleep(500);
//            putCon.signalAll();
            System.out.println("runTask " + name + " signalAll done ...");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(name + "InterruptedException ...");
        } finally {
            lock.unlock();
            System.out.println(name + " release lock ...");

        }
    }

    public void getTask(String name) {
        System.out.println(name + " start ...");
        try {
            lock.lock();

            System.out.println(name + " get lock ...");

            putCon.signalAll();
            System.out.println(name + " signalAll done ...");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(name + "InterruptedException ...");
        } finally {
//            lock.unlock();
            System.out.println(name + " release lock ...");

        }
    }

    public void testCondition() {
        for (int i = 0; i < 10; i++) {
            String name = "task" + i;
            if (i == 9) {
                executorService.submit(()-> getTask(name));
                continue;
            }
            executorService.submit(() -> runTask(name));

        }

    }


    public static void main(String[] args) {
//        testArrayBlockingQueue();
        new BlockingQueueTest().testCondition();
    }
}
