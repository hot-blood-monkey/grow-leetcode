package com.example.demo.leetCode.Q42;

public class Q42 {
    public static int trap(int[] height) {
        int maxV = 0;

        if (height.length <= 2) {
            return maxV;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int leftH = 0;
        for (int i = 1; i < height.length; i++) {
            leftH = Math.max(height[i-1], leftH);
            leftMax[i] = leftH;
        }

        int rightH = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            rightH = Math.max(height[i+1], rightH);
            rightMax[i] = rightH;
        }

        for (int i = height.length - 1; i >= 0; i--) {
            maxV += Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }

        return maxV;
    }


    public static void main(String[] args) {
        int[] height = new int[] {4,2,0,3,2,5};
        int res = trap(height);
        System.out.println(res);
    }
}
