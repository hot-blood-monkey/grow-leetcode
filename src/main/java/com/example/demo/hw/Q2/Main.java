package com.example.demo.hw.Q2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author zh
 * @date 2021-02-11 21:24
 **/

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        List<Integer> treeList = Arrays.stream(s1.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        if (treeList.size() <= 1) {
            System.out.println(s1);
            return;
        }

        //
        int i = 1;
        int sum = 1;
        List<Integer> numList = new ArrayList<>();
        while (sum < treeList.size()) {
            numList.add(i);
            i = i * 2;
            sum += i;
        }

        int lastIndex = sum - i;
        StringBuilder sb = new StringBuilder();
        for (int i1 = numList.size() - 1; i1 >= 0; i1--) {
            int innerStart = lastIndex - numList.get(i1);
            for (int j= innerStart; j < lastIndex; j++) {
                sb.append(treeList.get(j));
                sb.append(" ");
            }
            lastIndex = lastIndex - numList.get(i1);
        }

        System.out.println(sb.toString().trim());



    }
}
