package com.example.demo.leetCode.Q39;

//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//        candidates 中的数字可以无限制重复被选取。
//
//        说明：
//
//        所有数字（包括 target）都是正整数。
//        解集不能包含重复的组合。 
//        示例 1：
//
//        输入：candidates = [2,3,6,7], target = 7,
//        所求解集为：
//        [
//        [7],
//        [2,2,3]
//        ]
//        示例 2：
//
//        输入：candidates = [2,3,5], target = 8,
//        所求解集为：
//        [
//          [2,2,2,2],
//          [2,3,3],
//          [3,5]
//        ]
//         
//
//        提示：
//
//        1 <= candidates.length <= 30
//        1 <= candidates[i] <= 200
//        candidate 中的每个元素都是独一无二的。
//        1 <= target <= 500
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/combination-sum


import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * @author zh
 * @date 2021-02-20 09:42
 **/

public class Q39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> resSet = new HashSet<>();
        Arrays.sort(candidates);

        backUp(resSet, new ArrayList<>(), 0, candidates, target);

        return new ArrayList<>(resSet);
    }

    private void backUp(Set<List<Integer>> resSet, ArrayList<Integer> resList, int tempSum, int[] candidates, int target) {
        if (tempSum == target) {
            resSet.add(resList);
            return;
        } else if (tempSum > target) {
            return;
        }

        int candidate;
        for (int i = 0; i < candidates.length; i++) {
            candidate = candidates[i];

            ArrayList<Integer> nextResList = new ArrayList<>(resList);
            nextResList.add(candidate);

            int[] nextCandidates = Arrays.copyOfRange(candidates, i, candidates.length);
            backUp(resSet, nextResList, tempSum + candidate, nextCandidates, target);
        }

    }


    public static void main(String[] args) {
        int[] source = new int[]{2,3,5};
        Object o = new Q39().combinationSum(source, 8);
        System.out.println(JSON.toJSONString(o));
    }


}
