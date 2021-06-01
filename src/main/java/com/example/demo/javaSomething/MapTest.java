package com.example.demo.javaSomething;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zh
 * @date 2021-02-18 18:05
 **/

public class MapTest {
    private static Map<String, String> map = new HashMap<>();


    private static Map<String, String> currentMap = new ConcurrentHashMap<>();

    private static volatile Integer count  = 0;


    public static void main(String[] args) {
        // 线程1 => t1
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread1 : " + count);
                count ++;
//                for (int i = 0; i < 99999999; i++) {
//                    map.put("thread_key" + i, "thread1_value" + i);
//                }
            }
        }).start();
        // 线程2 => t2
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread2 : " + count);
                count++;
//                for (int i = 0; i < 99999999; i++) {
//                    map.put("thread_key" + i, "thread2_value" + i);
//                }
            }
        }).start();

        System.out.println(Integer.numberOfLeadingZeros(0) | 2<<2);


    }

}
