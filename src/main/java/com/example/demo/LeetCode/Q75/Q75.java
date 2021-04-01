package com.example.demo.LeetCode.Q75;

import com.alibaba.fastjson.JSON;

public class Q75 {
    public void sortColors(int[] nums) {
        sortF(0, nums.length - 1, nums);
    }

    public void sortF(int start, int end, int[] nums) {
        if (end - start < 1) {
            return;
        }

        int leftS = start;
        int rightE = end;

        int mid = nums[start];
        while (start < end) {
            if (nums[start] <= mid) {
                start ++;
            } else if (nums[end] > mid) {
                end --;
            } else {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start ++;
                end --;
            }


        }

        sortF(leftS, start, nums);
        sortF(end, rightE, nums);
    }


    public static void main(String[] args) {
        Q75 q75 = new Q75();
        int[] nums = new int[] {2,0,2,1,1,0};
        q75.sortColors(nums);
        System.out.println(JSON.toJSON(nums));
    }
}
