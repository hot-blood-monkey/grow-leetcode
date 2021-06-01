package com.example.demo.sort10;

import com.alibaba.fastjson.JSON;

/**
 * @author zh
 * @date 2021-02-19 17:43
 **/

public class BubbleSort {


    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j]>array[j+1]) {
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }

            }
        }

        return array;
    }


    public static void main(String[] args) {
        int[] source = new int[]{4};
        int[] res = bubbleSort(source);
        System.out.println(JSON.toJSONString(res));

    }
}
