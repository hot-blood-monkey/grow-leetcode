package com.example.demo.javaSomething;

import com.example.demo.javaSomething.model.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeMinLevelDemo {


    public static int minLevel(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.add(treeNode);
        int level = 0;
        int levelLength = 0;
        while (!queue.isEmpty()) {
            levelLength = queue.size();
            level = level + 1;
            for (int i = 0; i < levelLength; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left == null && curNode.right == null) {
                    return level;
                }

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }

                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

        }

        return level;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l1l1 = new TreeNode(4);
        TreeNode l1l1l1 = new TreeNode(6);
        TreeNode r1l1 = new TreeNode(5);

        root.left = l1;
        root.right = r1;

        l1.left = l1l1;
        l1l1.left = l1l1l1;

        r1.left = r1l1;


        int res = minLevel(root);
        System.out.println(res);

    }
}
