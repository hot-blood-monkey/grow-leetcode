package com.example.demo.LeetCode.Q188;

public class Q188M2 {


    public int maxProfit(int k, int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int length = prices.length;
        if (k >= length/2) {
            return maxProfit(prices);
        }

        int[][][] dp = new int[length][k + 1][2];
        for (int i = 1; i <= k; i++) {
            dp[0][i][0] = 0;
            dp[0][i][1] = -prices[0];
        }
        for (int i = 1; i < length; i++) {
            for (int j = k; j > 0; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[length - 1][k][0];

    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }



        public static void main(String[] args) {
        int[] source = new int[]{
                1,4,2,11,7};

        Q188M2 q = new Q188M2();
        int res = q.maxProfit(2,source);
        System.out.println(res);
    }
}
