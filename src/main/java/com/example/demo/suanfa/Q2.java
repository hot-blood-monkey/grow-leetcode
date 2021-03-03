package com.example.demo.suanfa;

import com.alibaba.fastjson.JSON;

/**
 * @author zh
 * @date 2021-02-27 10:36
 **/

public class Q2 {


    public static int noise(int n, int m, int[][] source) {
        int resNum = 0;
        int[][] res = new int[n][m];


        // 1. 遍历数组
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                int temp = calculate(row, col, source);
                res[row][col] = temp;
                resNum += temp;
            }
        }

        return resNum;

    }

    private static int calculate(int row, int col, int[][] source) {
        int res = 0;
        for (int[] s : source) {
            if (row == s[0] && col == s[1]) {
                return s[2];
            }

            int d = Math.max(Math.abs(col- s[1]), Math.abs(row - s[0]));

            int noise = s[2] - d;
            res = Math.max(noise, res);
        }

        return res;
    }


    public static void main(String[] args) {
        int[][] source = new int[][] {{3,4,3}, {1,1,4}};
        int res = noise(5, 6, source);
        System.out.println(JSON.toJSONString(res));
    }


}
