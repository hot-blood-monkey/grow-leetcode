package com.example.demo.LeetCode.Q122;

public class Q122 {


    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        dp[0][1] = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i -1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i -1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }


    public static void main(String[] args) {
        int[] source = new int[] {7,1,5,3,6,4};

        Q122 q = new Q122();
        int res = q.maxProfit(source);
        System.out.println(res);
    }
}
