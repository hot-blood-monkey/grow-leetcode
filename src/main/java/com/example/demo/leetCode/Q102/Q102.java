package com.example.demo.leetCode.Q102;

import com.example.demo.leetCode.TreeNode;

import java.util.*;

/**
 *
 * @author zh
 * @date 2021-03-04 00:41
 **/

public class Q102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> rowList = new ArrayList<> ();
            for (int i=0; i<len; i++) {
                TreeNode cur = queue.poll();

                rowList.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(rowList);
        }

        return res;
    }


}
