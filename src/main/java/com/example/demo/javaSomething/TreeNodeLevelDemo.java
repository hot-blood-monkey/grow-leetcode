package com.example.demo.javaSomething;

import com.example.demo.javaSomething.model.TreeNode;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树层序遍历
 */
public class TreeNodeLevelDemo {
    public static void treeLevel(TreeNode root) {
        Queue<TreeNode> queue = new LinkedBlockingQueue();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            System.out.println(curNode.value);

            if (curNode.left != null) {
                queue.add(curNode.left);
            }

            if (curNode.right != null) {
                queue.add(curNode.right);
            }

        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode l2 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);

        root.left = l1;
        root.right = r1;


    }

}
