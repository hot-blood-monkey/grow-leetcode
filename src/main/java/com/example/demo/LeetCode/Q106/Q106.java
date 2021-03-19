package com.example.demo.LeetCode.Q106;

import com.example.demo.LeetCode.TreeNode;

/**
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * <p>
 * 3
 * / \
 * 9  20
     * /  \
     * 15   7
 *
 * @author zh
 * @date 2021-03-18 15:44
 **/

public class Q106 {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeSub(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    private TreeNode buildTreeSub(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart == postEnd || inStart == inEnd) {
            return null;
        }


        int inRootIndex = inStart;
        for (; inRootIndex < inEnd; inRootIndex++) {
            if (inorder[inRootIndex] == postorder[postEnd - 1]) {
                break;
            }
        }

        int leftTreeLen = inRootIndex - inStart;
        TreeNode root = new TreeNode(postorder[postEnd - 1]);
        root.left = buildTreeSub(inorder, inStart, inRootIndex, postorder, postStart, postStart + leftTreeLen);
        root.right = buildTreeSub(inorder, inRootIndex + 1, inEnd, postorder, postStart + leftTreeLen, postEnd - 1);
        return root;
    }


    public static void main(String[] args) {
        Q106 q = new Q106();
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        TreeNode res = q.buildTree(inorder, postorder);
        System.out.println(res.val);
    }
}
