package com.example.demo.leetCode.Q48;

//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
//        你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//        输出：[[7,4,1],[8,5,2],[9,6,3]]


//解一
//自外向内一共有不超过 n/2 层（单个中心元素不算一层）矩形框。
// 对于第 times 层矩形框，其框边长 len=nums-(times*2)，将其顺时针分为 4 份 ，len-1 的边，对四条边进行元素的循环交换即可。
// times层， temp = matrix[times][times + i];
// matrix[times][times + i] = matrix[times + len - 1][times + i];
// matrix[times + len - 1][times + i] = matrix[times + len - 1][times + len - 1];
// matrix[times + len - 1][times + len - 1] = matrix[times][times + len -1];
// matrix[times][times + len -1] = temp;


import com.alibaba.fastjson.JSON;

/**
 * @author zh
 * @date 2021-02-20 10:31
 **/

public class Q48 {
    public void rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int nums = matrix.length;
        int times = 0;
        while(times <= (nums >> 1)){
            int len = nums - (times << 1);
            for(int i = 0; i < len - 1; ++i){
                int temp = matrix[times][times + i];
                matrix[times][times + i] = matrix[times + len - i - 1][times];
                matrix[times + len - i - 1][times] = matrix[times + len - 1][times + len - i - 1];
                matrix[times + len - 1][times + len - i - 1] = matrix[times + i][times + len - 1];
                matrix[times + i][times + len - 1] = temp;
            }
            ++times;
        }
    }

    public void rotate180R(int[][] matrix) {
        if (matrix.length <= 1) {
            return;
        }

        int times = matrix.length / 2;
        int time = 0;
        while (time <= times) {
            int len = matrix.length - (time << 2);
            for (int i = 0; i < len- 1; i++) {
                int temp = matrix[time][time + i];
                matrix[time][time + i] = matrix[time + len - 1][time + len - 1 -i];
                matrix[time + len - 1][time + len - 1 -i] = temp;

                temp = matrix[time + len - 1- i][time];
                matrix[time + len - 1- i][time] = matrix[time + i][time + len - 1];
                matrix[time + i][time + len - 1] = temp;
            }
            time ++;
        }
    }


    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        new Q48().rotate180R(matrix);
        System.out.println(JSON.toJSONString(matrix));
    }
}
