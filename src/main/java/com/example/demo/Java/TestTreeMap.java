package com.example.demo.Java;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zh
 * @date 2021-03-13 18:56
 **/

public class TestTreeMap {


    public static void main(String[] args) {
        Map<Integer, Integer> m = new LinkedHashMap<>();
        Map<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        map.put(4, 4);
        map.put(2, 2);
        map.put(5, 5);
        map.put(3, 3);

        for (Map.Entry entry : map.entrySet()) {
            System.out.println("key=" + entry.getKey() + ":value=" + entry.getValue());
        }

    }
}
