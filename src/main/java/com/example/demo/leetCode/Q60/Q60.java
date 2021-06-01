package com.example.demo.leetCode.Q60;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Q60 {
    public String getPermutation(int n, int k) {

        List<String> res = new ArrayList<>();
        List<Integer> hasChoose = new ArrayList<>();

        subPermutation(n, res, hasChoose);
        return res.get(k-1);

    }

    private void subPermutation(int n, List<String> res, List<Integer> hasChoose) {
        if (hasChoose.size() == n) {
            res.add(hasChoose.stream().map(String::valueOf).collect(Collectors.joining()));
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (hasChoose.contains(i)) {
                continue;
            }

            hasChoose.add(i);
            subPermutation(n, res, hasChoose);
            hasChoose.remove(hasChoose.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q60 q = new Q60();
        String res = q.getPermutation(9, 17223);
        System.out.println(res);
    }
}
