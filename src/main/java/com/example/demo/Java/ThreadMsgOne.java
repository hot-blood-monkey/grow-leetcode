package com.example.demo.Java;

import java.util.concurrent.Callable;

/**
 * @author zh
 * @date 2021-03-03 13:28
 **/

public class ThreadMsgOne {

    public static class Si {
        private Integer num;

        public Si(int num) {
            this.num = num;
        }
    }


    public static Si si = new Si(1);


    public static char[] buildArgs() {
        int temp = 65;
        char[] charArray = new char[26];
        for (int i = charArray.length - 1; i >= 0; i--) {
            charArray[i] = (char) (temp + i);
        }

        return charArray;
    }


    public static int[] buildNums() {
        int[] array = new int[26];
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = i;
        }

        return array;
    }


    public static void runOne() {
        char[] chars = buildArgs();
        int i = 0;
        while (i + 1 < chars.length) {
            synchronized (si) {
                while (si.num == 2) {
                    try {
                        si.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(chars[i++]);
                System.out.print(chars[i++]);
                si.num = 2;
                si.notifyAll();

            }
        }
    }

    public static void runTwo() {
        int[] nums = buildNums();
        int i = 0;
        while (i + 1 < nums.length) {
            synchronized (si) {
                while (si.num == 1) {
                    try {
                        si.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(nums[i++]);
                System.out.print(nums[i++]);
                si.num = 1;
                si.notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        new Thread(() -> runOne()).start();
        new Thread(() -> runTwo()).start();
    }

}
