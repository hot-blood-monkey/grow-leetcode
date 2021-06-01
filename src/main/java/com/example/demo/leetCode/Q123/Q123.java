package com.example.demo.leetCode.Q123;

import com.alibaba.fastjson.JSON;

public class Q123 {


    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int[][][] dp = new int[prices.length][2][2];

        dp[0][0][1] = -prices[0];
        dp[0][1][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1] + prices[i]);
            dp[i][0][1] = Math.max(dp[i - 1][0][1], -prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][0][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][0] - prices[i]);
            System.out.println(JSON.toJSON(prices[i]));
            System.out.println(JSON.toJSON(dp[i]));
            System.out.println("--------");
        }


        return dp[prices.length - 1][1][0];
    }


    public static void main(String[] args) {
        int[] source = new int[]{1, 2, 3, 4, 5};

        Q123 q = new Q123();
        int res = q.maxProfit(source);
        System.out.println(res);
    }
}
