package com.example.demo.LeetCode.Q42;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q42M2 {
    public static int trap(int[] height) {
        int maxV = 0;

        if (height.length <= 2) {
            return maxV;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!deque.isEmpty() && height[deque.peekFirst()] < height[i]) {
                int curIndex = deque.pollFirst();
                if (deque.isEmpty()) {
                    continue;
                } else {
                    int leftIndex = deque.peekFirst();
                    int h = Math.min(height[leftIndex], height[i]);
                    maxV += (h - height[curIndex]) * (i - leftIndex - 1);
                }

            }

            deque.addFirst(i);
        }


        return maxV;
    }


    public static void main(String[] args) {
        int[] height = new int[]{4, 2, 0, 3, 2, 5};
        int res = trap(height);
        System.out.println(res);
    }
}
