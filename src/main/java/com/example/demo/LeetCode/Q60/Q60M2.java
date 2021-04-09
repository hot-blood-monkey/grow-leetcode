package com.example.demo.LeetCode.Q60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q60M2 {
    public String getPermutation(int n, int k) {
        // 1-1000 --- 0-999
        // 1000 / 1000 = 1；  999 / 1000 = 0
        k--;
        boolean[] hasChoose = new boolean[n + 1];
        Arrays.fill(hasChoose, false);

        int[] fa = new int[n + 1];
        fa[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            fa[i] = fa[i - 1] * i;
        }

        StringBuilder sb = new StringBuilder();

        int index = 1;
        while (index <= n) {
            int cnt = fa[n - index];
            int chooseIndex = k / cnt;
            int count = 1;
            int chooseNum = 0;
            for (int i = 1; i < hasChoose.length; i++) {
                if (hasChoose[i]) {
                    continue;
                }

                if (count == chooseIndex + 1) {
                    chooseNum = i;
                }
                count ++;
            }

            sb.append(chooseNum);
            k = k % cnt;
            hasChoose[chooseNum] = true;
            index ++;
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        Q60M2 q = new Q60M2();
        String res = q.getPermutation(9, 17223);
        System.out.println(res);
    }
}
