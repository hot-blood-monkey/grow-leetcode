package com.example.demo.suanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author zh
 * @date 2021-02-09 10:43
 **/

public class P11 {

    public static void main(String[] args) {
        P11 p = new P11();
        Scanner s = new Scanner(System.in);
        Integer count = Integer.parseInt(s.nextLine());
        List<String> source = new ArrayList<> ();
        while (s.hasNext()) {
            String tem = s.nextLine();
            System.out.println("origin : " + tem);
            String res = p.deal(tem);
            System.out.println("res : " + res);
            source.add(res);
        }




    }


    public String deal(String s) {
        char[] source = s.toCharArray();
        char[] res = new char[s.length()];
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i >= 2 && source[i] == source[i-1] && source[i-1] == source[i-2]) {
                continue;
            }

            if (i >= 3 && source[i] == source[i-1] && source[i-2] == source[i - 3]) {
                continue;
            }

            res[j++] = s.charAt(i);
        }


        return String.valueOf(res, 0, j);
    }



}
