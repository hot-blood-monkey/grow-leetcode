package com.example.demo.LeetCode.Q64;

import com.alibaba.fastjson.JSON;

public class Q64 {
    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];
        int pre = 0;
        int index = 0;
        while (index < m) {
            pre += grid[index][0];
            res[index ++][0] = pre;
        }

        index = 0;
        pre = 0;
        while (index < n) {
            pre += grid[0][index];
            res[0][index ++] = pre;
        }

        for (int row = 1; row < m; row ++) {
            for (int col = 1; col < n; col ++) {
                res[row][col] = Math.min(res[row - 1][col], res[row][col - 1]) + grid[row][col];
            }
        }

        return res[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {{1,3,1},{1,5,1},{4,2,1}};
        int res = minPathSum(grid);
    }
}
