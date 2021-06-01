package com.example.demo.sort10;

import com.alibaba.fastjson.JSON;

public class QuickSort {

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length);
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end - start <= 1) {
            return;
        }

        // [start, lessIndex)
        int lessIndex = start;
        // [greaterIndex, end)
        int greaterIndex = end;
        int comparator = nums[start];
        int index = start;
        while (index < greaterIndex) {
            if (nums[index] < comparator) {
                swap(nums, index, lessIndex);
                index++;
                lessIndex++;
            } else if (nums[index] == comparator) {
                index++;
            } else {
                greaterIndex--;
                swap(nums, index, greaterIndex);
            }
        }

        quickSort(nums, start, lessIndex);
        quickSort(nums, greaterIndex, end);
    }


    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] source = new int[]{4, 2, 1, 3};
        quickSort.quickSort(source);
        System.out.println(JSON.toJSON(source));
    }
}
