package com.example.demo.javaSomething;

public class ThreadSafeSingleDemo {
    // 防止指令重拍
    private static volatile ThreadSafeSingleDemo singleDemo = null;

    public static ThreadSafeSingleDemo getSingleDemo() {
        if (singleDemo == null) {
            synchronized (ThreadSafeSingleDemo.class) {
                if (singleDemo == null) {
                    singleDemo = new ThreadSafeSingleDemo();
                }
            }
        }

        return singleDemo;
    }

    /**
     * 构造器私有
     */
    private ThreadSafeSingleDemo () {
    }
}
