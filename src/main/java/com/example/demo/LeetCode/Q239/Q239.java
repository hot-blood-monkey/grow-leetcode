package com.example.demo.LeetCode.Q239;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * 如果不使用“索引堆”要定位要更新的元素的索引，还是有一定技巧的，当然挖掘题目中的已知条件可以帮助我们找到解决方案。
 * <p>
 * （1）根据「力扣」第 155 题：最小栈这个问题的思路，我们想到需要一个辅助的数据结构，当“滑动窗口”在移动的时候，我们直接看这个数据结构，就可以很快知道此时“滑动窗口”的最大值；
 * <p>
 * 下面这一点是很关键的！
 * <p>
 * 如果“当前考虑的数”比之前来的数还要大，那么之前的数（如果还没有划出“滑动窗口”）就一定不会是“滑动窗口”的最大值，应该把它们移除，因为它们“永远不会有出头之日”。
 * <p>
 * （2）根据上面的分析，之前的数离开，后来的数加进来，感觉这个数据结构可能是“队列”，但是之前可能还有的数比“当前考虑的数”还要大，还不能出“队列”，感觉这个数据结构还有可能是“栈”（不好意思，又把你绕晕了，不妨先看后面）。又感觉是“队列”，又感觉是“栈”的，我们先停一下，还有一个问题没有解决：左边界出“滑动窗口”的时候怎么办？。
 * <p>
 * （3）“左边界出滑动窗口的时候”只有 1 种情况需要考虑，那就是：
 * <p>
 * 左边界恰好就是上一轮循环的滑动窗口的最大值，在这一轮“滑动窗口”右移，它必须被移出。
 * <p>
 * “左边界出滑动窗口”，左边界一定比当前考虑的数先进这个辅助的数据结构， 再结合 3（2），我们可以分析出这个辅助的数据结构即要是队列（先进先出），也要是栈（后进先出），因此“双端队列”是首选，因为要检测到左边界移除，左边界的索引很重要，知道索引也就知道了具体的值，因此“双端队列”里存的应该是数组的索引。
 * <p>
 * 作者：liweiwei1419
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum/solution/zui-da-suo-yin-dui-shuang-duan-dui-lie-cun-suo-yin/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author zh
 * @date 2021-03-16 10:59
 **/

public class Q239 {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        // 特判
        if (len == 0) {
            return new int[]{};
        }
        // 结果集
        List<Integer> res = new ArrayList<>();
        // 滑动窗口，注意：保存的是索引值
        LinkedBlockingDeque<Integer> deque = new LinkedBlockingDeque<>(k);

        for (int i = 0; i < len; i++) {
            // 1. 左边出队
            if (i >= k && i - deque.peekFirst() == k) {
                deque.pollFirst();
            }

            // 2. 右边入队
            int last = deque.peekLast();
            int first = deque.peekFirst();
            while (!deque.isEmpty() && last > first) {
                if (nums[last] < nums[i]) {
                    deque.peekLast();
                }
            }
        }

        return null;

    }


    public static void main(String[] args) {
        int[] source = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int[] res = maxSlidingWindow(source, 3);
        System.out.println(JSON.toJSONString(res));


    }
}
