package com.example.demo.leetCode.Q34;

//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
//        如果数组中不存在目标值 target，返回 [-1, -1]。
//
//        进阶：
//
//        你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
//         
//
//        示例 1：
//
//        输入：nums = [5,7,7,8,8,10], target = 8
//        输出：[3,4]
//        示例 2：
//
//        输入：nums = [5,7,7,8,8,10], target = 6
//        输出：[-1,-1]
//        示例 3：
//
//        输入：nums = [], target = 0
//        输出：[-1,-1]
//         
//
//        提示：
//
//        0 <= nums.length <= 105
//        -109 <= nums[i] <= 109
//        nums 是一个非递减数组
//        -109 <= target <= 109


import com.alibaba.fastjson.JSON;

/**
 * @author zh
 * @date 2021-02-19 17:34
 **/

public class Q34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};

        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = (end - start) / 2 + start;

            if (nums[mid] == target) {
                int first = mid;
                int last = mid;

                while (first >= 0 && nums[first] == target) {
                    first--;
                }

                while (last <= nums.length - 1 && nums[last] == target) {
                    last++;
                }

                res[0] = first + 1;
                res[1] = last - 1;
            }

            if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return res;
    }


    public static void main(String[] args) {
        int[] source = new int[]{1};
        int[] res = new Q34().searchRange(source, 1);
        System.out.println(JSON.toJSONString(res));
    }

}
