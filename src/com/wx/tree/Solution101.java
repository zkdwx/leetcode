package com.wx.tree;
//********************************************************************************************
//        101. Symmetric Tree
//        Easy
//
//        Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
//        For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//        1
//        / \
//        2   2
//        / \ / \
//        3  4 4  3
//
//
//
//        But the following [1,2,2,null,3,null,3] is not:
//
//        1
//        / \
//        2   2
//        \   \
//        3    3
//********************************************************************************************
import java.util.LinkedList;
import java.util.Queue;
public class Solution101 {
    //递归
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }
    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val != right.val) return false;
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
    //迭代
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left==null && right==null) continue;
            if (left==null||right==null) return false;
            if (left.val!=right.val) return false;
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Integer[] arr = {1, 2, 2, -1, 3, -1,3};
        TreeNode[] nodes = new TreeNode[arr.length];
        tree.createTree(arr, nodes);
        //*********************
//        boolean b = isSymmetric(nodes[0]);
//        System.out.println(b);
        boolean b = isSymmetric2(nodes[0]);
        System.out.println(b);
        //******************************
        System.out.println("前序遍历：");
        tree.preOrderTraverse(nodes[0]);
        System.out.println();
        System.out.println("中序遍历：");
        tree.inOrderTraverse(nodes[0]);
        System.out.println();
        System.out.println("后序遍历：");
        tree.postOrderTraverse(nodes[0]);

    }
}
