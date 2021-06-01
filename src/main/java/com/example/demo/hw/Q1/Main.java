package com.example.demo.hw.Q1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author zh
 * @date 2021-02-11 21:24
 **/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        // score aim
        Set<String> repeatSet = new HashSet<>();
        for (char c : s1.toCharArray()) {
            repeatSet.add(String.valueOf(c));
        }


        Set<String> res = new HashSet<>();
        String cStr;
        for (char c : s2.toCharArray()) {
            cStr = String.valueOf(c);
            if (repeatSet.contains(cStr)) {
                res.add(cStr);
            }

        }

        StringBuilder sb = new StringBuilder();
        Arrays.asList(res.toArray()).stream().sorted().forEach(
                sb::append
        );
        System.out.println(sb.toString());





    }
}
