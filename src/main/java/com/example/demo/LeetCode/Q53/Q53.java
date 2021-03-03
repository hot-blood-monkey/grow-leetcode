package com.example.demo.LeetCode.Q53;

/**
 * @author zh
 * @date 2021-02-20 16:18
 **/

public class Q53 {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int[] array = new int[nums.length];
        array[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            array[i] = Math.max(nums[i], array[i-1] + nums[i]);
            res = Math.max(res, array[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] source = new int[] {-1};
        Object o = new Q53().maxSubArray(source);
        System.out.println(o);
    }
}
