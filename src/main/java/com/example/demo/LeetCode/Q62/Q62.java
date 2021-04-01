package com.example.demo.LeetCode.Q62;

import com.alibaba.fastjson.JSON;

public class Q62 {
    public static int uniquePaths(int m, int n) {
        // f(0,0) = 1;
        // f(m,n) = f(m-1,n) + f(m, n-1);
        int[][] res = new int[m][n];
        int index = 0;
        while (index < m) {
            res[index++][0] = 1;
        }

        index = 0;
        while (index < n) {
            res[0][index++] = 1;
        }
        for (int row = 1; row < m; row++) {
            for (int col = 1; col < n; col++) {
                int left = (row - 1 < 0) ? 0 : res[row - 1][col];
                int up = (col - 1 < 0) ? 0 : res[row][col - 1];
                res[row][col] = left + up;
            }
        }

        return res[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int res = uniquePaths(3, 3);
        System.out.println(res);
    }
}
