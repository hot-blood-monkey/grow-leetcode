package com.example.demo.leetCode.Q78;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Q78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        subsets(nums, 0, res, new ArrayList<Integer>());
        return res;
    }

    private void subsets(int[] nums, int index, List<List<Integer>> res, List<Integer> list) {
        res.add(new ArrayList<>(list));
        for(int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsets(nums, i+1, res, list);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        Q78 q = new Q78();
        int[] nums = new int[] {1,2,3};
        Object res = q.subsets(nums);
        System.out.println(JSON.toJSON(res));
    }
}
