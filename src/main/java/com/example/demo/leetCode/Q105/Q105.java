package com.example.demo.leetCode.Q105;


import com.example.demo.leetCode.TreeNode;

/**
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * @author zh
 * @date 2021-03-18 15:10
 **/

public class Q105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeSub(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    private TreeNode buildTreeSub(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart == preEnd) {
            return null;
        }

        // 本层root
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRootIndex = inStart;
        for (; inRootIndex < inEnd; inRootIndex++) {
            if (preorder[preStart] == inorder[inRootIndex]) {
                break;
            }
        }

        int leftTreeLen = inRootIndex - inStart;

        // root.left
        root.left = buildTreeSub(preorder, preStart + 1, preStart + 1 + leftTreeLen, inorder, inStart, inRootIndex);

        // root.right
        root.right = buildTreeSub(preorder, preStart + 1 + leftTreeLen, preEnd, inorder, inRootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        Q105 q105 = new Q105();
        int[] preOrder = new int[]{3, 9, 20, 15, 7};
        int[] inOrder = new int[]{9, 3, 15, 20, 7};
        TreeNode res = q105.buildTree(preOrder, inOrder);
        System.out.println(res.val);
    }
}
