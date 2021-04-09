package com.example.demo.LeetCode.Q451;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class Q451 {
    public static String frequencySort(String s) {
        Map<String, Integer> countMap = new HashMap<>();
        Queue<String> queue = new PriorityQueue<>((k1, k2) -> countMap.get(k2) - countMap.get(k1));
        for (char c : s.toCharArray()) {
            String key = String.valueOf(c);
            if (!countMap.containsKey(key)) {
                countMap.put(key, 0);
            }
            countMap.put(key, countMap.get(key) + 1);
        }
        queue.addAll(countMap.keySet());

        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            String key = queue.poll();
            Integer count = countMap.get(key);
            while (count > 0) {
                sb.append(key);
                count --;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaccca";
        String res = frequencySort(s);
        System.out.println(res);
    }
}
