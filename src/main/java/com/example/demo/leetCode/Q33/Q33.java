package com.example.demo.leetCode.Q33;

/**
 * @author zh
 * @date 2021-02-18 00:03
 **/

public class Q33 {
    public int search(int[] nums, int target) {
        int res = -1;
        int start = 0;
        int end = nums.length-1;
        int mid;

        while (start <= end) {
            mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            }

            // 右边有序
            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end] ) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                // 左边有序
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }

        return res;

    }

    public static void main(String[] args) {
        int[] nums = new int[] {5,1,3};

        int res = new Q33().search(nums, 5);
        System.out.println(res);
    }
}
