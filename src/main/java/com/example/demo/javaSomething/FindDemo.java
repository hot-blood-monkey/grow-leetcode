package com.example.demo.javaSomething;

public class FindDemo {


    public static int find(int[] array, int aim) {
        int end = array.length;
        int start = 0;

        while (start < end) {
            int mid = (end - start) / 2 + start;
            if (array[mid] == aim) {
                return mid;
            } else if (array[mid] > aim) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static int find2(int[] array, int aim) {
        int end = array.length - 1;
        int start = 0;

        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (array[mid] == aim) {
                return mid;
            } else if (array[start] < array[mid]) {
                // 左侧有序
                if (array[mid] > aim && array[start] <= aim) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // 左侧无序，右侧有序
                if (array[mid] < aim && array[end] >= aim) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 9, 0, 1, 2, 3, 4};
        int res = find2(array, 4);
        System.out.println(res);

    }
}
