package com.example.demo.LeetCode.Q6;


/**
 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。

 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：

 P   A   H   N
 A P L S I I G
 Y   I   R
 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。

 请你实现这个将字符串进行指定行数变换的函数：

 string convert(string s, int numRows);



 */

import java.util.ArrayList;
import java.util.List;

/**
 * @author zh
 * @date 2021-03-03 18:33
 **/

public class Q6 {
    public static String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }

        int rowIndex = 0;
        List<StringBuilder> res = new ArrayList<>();
        while (rowIndex < numRows) {
            res.add(new StringBuilder());
            rowIndex++;
        }

        char[] arrays = s.toCharArray();
        int i = 0; int flag = -1;
        for (char c : arrays) {
            if (i==0 || i==numRows-1) flag = -flag;
            res.get(i).append(c);
            i +=flag;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : res) {
            sb.append(stringBuilder);
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        String res = convert("PAYPALISHIRING", 3);
        System.out.println(res);
    }

}
