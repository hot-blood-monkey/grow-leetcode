package com.example.demo.LeetCode.Q215;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zh
 * @date 2021-03-14 16:30
 **/

public class Q215 {
    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue(k);
        for (int num : nums) {
            if (queue.size() < k) {
                if (queue.contains(num)) {
                    continue;
                }
                queue.add(num);
            } else {
                if (queue.contains(num)) {
                    continue;
                }

                if (num > queue.peek()) {
                    queue.remove();
                    queue.add(num);
                }
            }
        }


        return queue.peek();
    }


    public static void main(String[] args) {
        int[] nums = new int[]{5,2,5,3,5,3,1,1,3,2};
        int res = findKthLargest(nums, 2);
        System.out.println(res);
    }


}
