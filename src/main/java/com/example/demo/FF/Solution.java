package com.example.demo.FF;


import com.alibaba.fastjson.JSON;

public class Solution {
//    给定一个按照升序排列的整数数组 nums，和一个目标值 target。
//    找出给定目标值在数组中的开始位置和结束位置。
//
//    如果数组中不存在目标值 target，返回 [-1, -1]。
//
//    进阶：
//
//    你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//             
//
//    示例 1：
//
//    输入：nums = [5,7,7,8,8,10], target = 8
//    输出：[3,4]
//    示例 2：
//
//    输入：nums = [5,7,7,8,8,10], target = 6
//    输出：[-1,-1]
//    示例 3：
//
//    输入：nums = [], target = 0
//    输出：[-1,-1]
    public static int[] find(int[] source, int target) {
        int start = binarySearchLeft(source, target);
        int end = binarySearchRight(source, target);
        return new int[] {start, end};
    }

    private static int binarySearchLeft(int[] source, int target) {
        int ans = -1;
        int left = 0;
        int right = source.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (source[mid] >= target) {
                right = mid - 1;
            } else if (source[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    private static int binarySearchRight(int[] source, int target) {
        int ans = -1;
        int left = 0;
        int right = source.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (source[mid] <= target) {
                left = mid + 1;
            } else if (source[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] source = new int[] {};
        Object res = find(source, 6);
        System.out.println(JSON.toJSON(res));
    }
}
