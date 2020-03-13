package com.wx.tree;
//********************************************************************************************
//        108. Convert Sorted Array to Binary Search Tree
//        Easy
//
//        Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
//
//        For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
//
//        Example:
//
//        Given the sorted array: [-10,-3,0,5,9],
//
//        One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
//
//        0
//        / \
//        -3   9
//        /   /
//        -10  5


//********************************************************************************************
public class Solution108 {
    public static TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return bstHelper(nums, 0, nums.length - 1);

    }

    private static TreeNode bstHelper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = bstHelper(nums, start, mid - 1);
        node.right = bstHelper(nums, mid + 1, end);
        return node;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] arr = {-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(arr);


        //******************************
        System.out.println("前序遍历：");
        tree.preOrderTraverse(root);

    }
}
