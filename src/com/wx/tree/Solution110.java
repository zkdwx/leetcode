package com.wx.tree;
//********************************************************************************************
//        110. Balanced Binary Tree
//        Easy
//
//        Given a binary tree, determine if it is height-balanced.
//
//        For this problem, a height-balanced binary tree is defined as:
//
//        a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//
//
//
//        Example 1:
//
//        Given the following tree [3,9,20,null,null,15,7]:
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//
//        Return true.
//
//        Example 2:
//
//        Given the following tree [1,2,2,3,3,null,null,4,4]:
//
//        1
//        / \
//        2   2
//        / \
//        3   3
//        / \
//        4   4
//
//        Return false.

//********************************************************************************************
public class Solution110 {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = 0;
        int r = 0;
        if (root.left != null) {
            l = maxDepth(root.left);
        }
        if (root.right != null) {
            r = maxDepth(root.right);
        }
        if (Math.abs(l - r) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Integer[] arr = {1,2,2,3,3,null,null,4,4,null,null,null,null,null,null};
        TreeNode[] nodes = new TreeNode[arr.length];
        tree.createTree(arr, nodes);
        boolean b= isBalanced(nodes[0]);
        System.out.println(b);


        //******************************
        System.out.println("前序遍历：");
        tree.preOrderTraverse(nodes[0]);

    }
}
