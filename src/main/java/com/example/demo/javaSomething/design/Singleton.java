package com.example.demo.javaSomething.design;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author zh
 * @date 2021-03-23 11:57
 **/

public class Singleton {

    private volatile static Singleton instance;

    private Singleton() {

    }


    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return null;
            }
        };

        FutureTask futureTask = new FutureTask(callable);
        Thread thread = new Thread(futureTask);

        return instance;
    }

}
