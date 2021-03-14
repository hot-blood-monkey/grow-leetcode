package com.example.demo.LeetCode.Q347;

import com.alibaba.fastjson.JSON;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zh
 * @date 2021-03-14 14:40
 **/

public class Q347 {

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> frequentMap = new HashMap<>();
        for (int num : nums) {
            if (!frequentMap.containsKey(num)) {
                frequentMap.put(num, 0);
            }

            frequentMap.put(num, frequentMap.get(num) + 1);
        }

        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(frequentMap::get));
        for (Integer num : frequentMap.keySet()) {
            if (queue.size() < k) {
                queue.add(num);
            } else if (frequentMap.get(num) > frequentMap.get(queue.peek())) {
                queue.remove();
                queue.add(num);
            }

        }

        List<Integer> list = new ArrayList<>(queue);
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,2,5,3,5,3,1,1,3,2};
        int[] res = topKFrequent(nums, 2);
        System.out.println(JSON.toJSONString(res));

    }


}
