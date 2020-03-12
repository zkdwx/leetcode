package com.wx.tree;
//********************************************************************************************
//        104. Maximum Depth of Binary Tree
//        Easy
//
//        Given a binary tree, find its maximum depth.
//
//        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//        Note: A leaf is a node with no children.
//
//        Example:
//
//        Given binary tree [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//
//        return its depth = 3.

//********************************************************************************************
public class Solution104 {
    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;

    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Integer[] arr = {1, 2, 2, -1, 3, -1};
        TreeNode[] nodes = new TreeNode[arr.length];
        tree.createTree(arr, nodes);

        int d = maxDepth(nodes[0]);
        System.out.println(d);
        System.out.println("前序遍历：");
        tree.preOrderTraverse(nodes[0]);

    }
}
