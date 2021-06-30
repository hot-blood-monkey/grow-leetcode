package com.example.demo.javaSomething;

public class LazySingleDemo {
    private static volatile LazySingleDemo singleDemo;

    public static LazySingleDemo get() {
        if (singleDemo == null) {
            synchronized (LazySingleDemo.class) {
                if (singleDemo == null) {
                    singleDemo = new LazySingleDemo();
                }
            }
        }
        return singleDemo;
    }


}
