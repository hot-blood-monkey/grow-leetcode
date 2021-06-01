package com.example.demo.leetCode.Q84;

public class Q84 {
    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int tempMin = 0;
        for (int left = 0; left < heights.length; left++) {
            tempMin = heights[left];
            for (int right = left; right < heights.length; right++) {
                tempMin = Math.min(tempMin, heights[right]);
                int tmpRes = (right - left + 1) * tempMin;
                res = Math.max(tmpRes, res);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Q84 q = new Q84();
        int[] heights = new int[] {2,1,5,6,2,3};
        int res = q.largestRectangleArea(heights);
        System.out.println(res);
    }
}
