package com.example.demo.LeetCode.Q31;

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
//        如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
//
//        必须 原地 修改，只允许使用额外常数空间。
//
//         
//
//        示例 1：
//
//        输入：nums = [1,2,3]
//        输出：[1,3,2]
//        示例 2：
//
//        输入：nums = [3,2,1]
//        输出：[1,2,3]
//        示例 3：
//
//        输入：nums = [1,1,5]
//        输出：[1,5,1]
//        示例 4：
//
//        输入：nums = [1]
//        输出：[1]
//         
//
//        提示：
//
//        1 <= nums.length <= 100
//        0 <= nums[i] <= 100
//        [4,2,0,2,3,2,0]
//        [4,2,0,3,0,2,2]


// input [4,2,0,2,3,2,0]
// output [4,2,0,3,0,2,2]




//如何得到这样的排列顺序？这是本文的重点。我们可以这样来分析：
//
//        我们希望下一个数比当前数大，这样才满足“下一个排列”的定义。因此只需要将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
//        我们还希望下一个数增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
//        在尽可能靠右的低位进行交换，需要从后向前查找
//        将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
//        将「大数」换到前面后，需要将「大数」后面的所有数重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
//        以上就是求“下一个排列”的分析过程

//
//以上就是求“下一个排列”的分析过程。
//
//        算法过程
//        标准的“下一个排列”算法可以描述为：
//
//        从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
//        在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
//        将 A[i] 与 A[k] 交换
//        可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
//        如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
//        该方法支持数据重复，且在 C++ STL 中被采用。


import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * @author zh
 * @date 2021-02-19 15:23
 **/

public class Q31 {

    public void nextPermutation(int[] nums) {

        int index = nums.length - 1;
        int preIndex;

        while (index >= 0) {
            preIndex = index - 1;
            if (preIndex >= 0) {
                if (nums[preIndex] < nums[index]) {
                    int last = nums.length - 1;
                    while (last > preIndex) {
                        // 在[pre+1，end]区间中的,找到所有比preIndex值大的数，再在这些数中取最小，与preIndex的值交换
                        // 此时[pre+1，end]一定是一个递减的区间，从后往前找，第一个符合条件的就是目标值
                        if (nums[last] > nums[preIndex]) {
                            int temp = nums[preIndex];
                            nums[preIndex] = nums[last];
                            nums[last] = temp;

                            Arrays.sort(nums, preIndex + 1, nums.length);
                            return;

                        }
                        last--;
                    }
                }
            }

            index--;
        }

        Arrays.sort(nums);

    }

    public static void main(String[] args) {
        int[] source = new int[]{4,2,0,2,3,2,0};
        new Q31().nextPermutation(source);
        System.out.println(JSON.toJSONString(source));
    }

}
