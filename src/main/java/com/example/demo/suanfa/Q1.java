package com.example.demo.suanfa;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * @author zh
 * @date 2021-02-22 19:34
 **/

public class Q1 {

    public static int[] convert(int[] source) {

        Arrays.sort(source);
        List<Integer> s1 = Lists.newArrayList();
        List<Integer> s2 = Lists.newArrayList(source.length);
        for (int i : source) {
            if (i % 2 == 0) {
                s2.add(i);
            } else {
                s1.add(i);
            }
        }

        int size = Math.max(s2.size(), s1.size());
        int l1 = 0;
        int l2 = 0;
        int[] res = new int[size * 2];
        for (int index = 0; index < size * 2; index++) {
            // 取偶数
            if (index % 2 == 0) {
                if (l2 < s2.size()) {
                    res[index] = s2.get(l2++);
                }
            } else {
                // 奇数
                if (l1 < s1.size()) {
                    res[index] = s1.get(l1++);
                }
            }

        }

        return res;

    }

    public static void main(String[] args) {
        int[] source = new int[]{3, 1};
        int[] res = convert(source);
        System.out.println(JSON.toJSONString(res));
    }
}
