package com.example.demo.leetCode.Q662;

import com.example.demo.leetCode.TreeNode;

import java.util.Deque;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 * <p>
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 * 示例 2:
 * <p>
 * 输入:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 3 层，宽度为 2 (5,3)。
 * 示例 3:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * 输出: 2
 * 解释: 最大值出现在树的第 2 层，宽度为 2 (3,2)。
 * 示例 4:
 * <p>
 * 输入:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * 输出: 8
 * 解释: 最大值出现在树的第 4 层，宽度为 8 (6,null,null,null,null,null,null,7)。
 * 注意: 答案在32位有符号整数的表示范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-width-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zh
 * @date 2021-03-16 19:08
 **/

public class Q662 {


    public static int widthOfBinaryTree(TreeNode root) {
        int max = 1;
        Deque<TreeNode> queue = new LinkedBlockingDeque<>();
        Deque<Integer> list = new LinkedBlockingDeque<>();

        queue.add(root);
        int index = 1;
        list.add(index);
        while (!queue.isEmpty()) {
            // 计算当前层 num
            max = Math.max(list.peekLast() - list.peekFirst() + 1, max);

            int size = queue.size();
            max = Math.max(max, size);
            for (int i = 0; i < size; i++) {
                // 塞下一层
                TreeNode cur = queue.pollFirst();
                index = list.pollFirst();

                if (cur.left != null) {
                    queue.addLast(cur.left);
                    list.addLast(index * 2);
                }

                if (cur.right != null) {
                    queue.addLast(cur.right);
                    list.addLast(index * 2 + 1);
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        TreeNode l1S1 = new TreeNode(3);
        TreeNode l1S2 = new TreeNode(2);

        head.left = l1S1;
        head.right = l1S2;

        TreeNode l2S1 = new TreeNode(5);
        TreeNode l2S2 = new TreeNode(9);

        l1S1.left = l2S1;
        l1S2.right = l2S2;

        TreeNode l3S1 = new TreeNode(6);
        TreeNode l3S2 = new TreeNode(7);

        l2S1.left = l3S1;
        l2S2.right = l3S2;

        int res = widthOfBinaryTree(head);
        System.out.println(res);

    }
}
