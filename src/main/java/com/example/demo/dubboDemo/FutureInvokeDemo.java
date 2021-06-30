package com.example.demo.dubboDemo;


import java.util.concurrent.*;


public class FutureInvokeDemo {
    public static class TaskWithResult implements Callable<String> {

        public String call() throws Exception {
            // TODO Auto-generated method stub
            Thread.sleep(1000);
            return "OK";
        }

    }

    public static void worker(String name) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<String> st = exec.submit(new TaskWithResult());

        /*同步结果，而且设置超时时间*/
        try {
            System.out.println(st.get(10000, TimeUnit.MILLISECONDS));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }


    public static void main(String[] args) {
        worker("work1");

    }
}
