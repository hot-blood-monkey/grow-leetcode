package com.example.demo.LeetCode.Q90;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] usedArray = new boolean[nums.length];
        Arrays.fill(usedArray, false);
        List<Integer> curRes = new ArrayList<>();
        Arrays.sort(nums);
        subsetsFunc(nums, 0, usedArray, curRes, res);
        return res;
    }

    private void subsetsFunc(int[] nums, int path, boolean[] usedArray, List<Integer> curRes, List<List<Integer>> res) {
        res.add(new ArrayList<>(curRes));
        for (int i = path; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && !usedArray[i - 1]) {
                continue;
            }
            curRes.add(nums[i]);
            usedArray[i] = true;
            subsetsFunc(nums, i + 1, usedArray, curRes, res);
            usedArray[i] = false;
            curRes.remove(curRes.size() - 1);
        }
    }


    public static void main(String[] args) {
        Q90 q = new Q90();
        int[] nums = new int[] {5,5,5,5,5};
        Object res = q.subsetsWithDup(nums);
        System.out.println(JSON.toJSON(res));
    }
}
