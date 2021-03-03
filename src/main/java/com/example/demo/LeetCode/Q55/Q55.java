package com.example.demo.LeetCode.Q55;
//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
//
//        数组中的每个元素代表你在该位置可以跳跃的最大长度。
//
//        判断你是否能够到达最后一个下标。
//
//        示例 1：
//
//        输入：nums = [2,3,1,1,4]
//        输出：true
//        解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
//        示例 2：
//
//        输入：nums = [3,2,1,0,4]
//        输出：false
//        解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。


import java.util.HashMap;
import java.util.Map;

/**
 * @author zh
 * @date 2021-02-20 17:25
 **/

public class Q55 {
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }

        int steps = nums[0];
        if (steps == 0) {
            return false;
        }

        Map<Integer, Boolean> recordMap = new HashMap<>();

        return backup(recordMap, nums, 0);
    }

    private boolean backup(Map<Integer, Boolean> recordMap, int[] nums, int index) {
        if (index == nums.length-1) {
            return true;
        }

        if (recordMap.containsKey(index)) {
            return recordMap.get(index);
        }

        for (int i = 1; i <= nums[index]; i++) {
            boolean isOk = backup(recordMap, nums, index + i);
            if (isOk) return true;
        }

        recordMap.put(index, false);
        return false;
    }


    public static void main(String[] args) {
        int[] source = new int[]{2, 0, 0};
        Object o = new Q55().canJump(source);
        System.out.println(o);
    }
}
