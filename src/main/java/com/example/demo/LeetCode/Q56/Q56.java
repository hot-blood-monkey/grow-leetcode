package com.example.demo.LeetCode.Q56;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zh
 * @date 2021-02-28 20:12
 **/

public class Q56 {

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (int[] l1, int[] l2) -> {
            if (l1[0] == l2[0]) {
                return Integer.compare(l1[1], l2[1]);
            }

            return Integer.compare(l1[0], l2[0]);
        });

        List<int[]> res = new ArrayList<>();

        int[] resIndex = intervals[0];
        res.add(intervals[0]);

        for (int[] interval : intervals) {
            if (interval[0] <= resIndex[1]) {
                resIndex[1] = Math.max(interval[1], resIndex[1]);
            } else {
                resIndex = interval;
                res.add(interval);
            }
        }

        return res.toArray(new int[res.size()][]);
    }


    public static void main(String[] args) {
        // [[2,3],[5,5],[2,2],[3,4],[3,4]]
        int[][] source = new int[][] {{2,3},{2,2},{3,4}, {5,5}};
        int[][] res  = merge(source);
        System.out.println(JSON.toJSONString(res));

    }


}
