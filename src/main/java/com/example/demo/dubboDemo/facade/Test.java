package com.example.demo.dubboDemo.facade;

import java.util.Arrays;
import java.util.Random;

/**
 * @author zh
 * @date 2021-03-25 17:12
 **/

public class Test {
    private static float w1 = 10;
    private static float w2 = 20;
    private static float w3 = 70;


    public int find(int[] source, int target) {
        int res = -1;
        int start = 0;
        int end = source.length;
        while (start < end) {
            int mid = start + (end - start) /2;
//            int mid = (start + end)  /2;
            if (source[mid] == target) {
                res = source[mid];
            } else if (source[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return res;
    }


    public static class Node {
        float start;
        float end;
    }



    public String show() {
        Random rd = new Random();
        float f = rd.nextFloat() * 100;


        float[] floatArray = new float[] {w1, w2, w3};
        Arrays.sort(floatArray);

        float w1End = floatArray[0];
        float w2End = floatArray[1] + w1End;
        float w3End = floatArray[2] + w2End;


        String a = "A";
        String b = "B";
        String c = "C";

        if (f < w1End) {
            return a;
        } else if (f >= w1End && f < w2End) {
            return b;
        } else {
            return c;
        }
    }



}
