package com.example.demo.LeetCode.Q47;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        permuteUnique(nums, new ArrayList<Integer>(), res);
        return res;

    }

    private void permuteUnique(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(list.stream().map(o -> nums[o]).collect(Collectors.toList()));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(i)) {
                continue;
            }

            if (i > 0 && nums[i] == nums[i-1] && !list.contains(i - 1)) {
                continue;
            }

            list.add(i);
            permuteUnique(nums, list, res);
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {
        Q47 q = new Q47();
        int[] source = new int[] {1,1,2};
        Object o = q.permuteUnique(source);
        System.out.println(JSON.toJSON(o));
    }
}
