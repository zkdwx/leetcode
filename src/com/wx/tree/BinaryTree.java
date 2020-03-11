package com.wx.tree;

public class BinaryTree {

    //创建二叉树
    public static void createTree(Integer[] arr, TreeNode[] nodes) {
        for (int i = 0; i < arr.length; i++) {
            nodes[i] = new TreeNode(arr[i]);
            nodes[i].left = null;
            nodes[i].right = null;
        }
        for (int i = 0; i < arr.length / 2 - 1; i++) {
            nodes[i].left = nodes[2 * i + 1];
            nodes[i].right = nodes[2 * i + 2];
        }
        if (arr.length % 2 == 0) {
            nodes[arr.length / 2 - 1].left = nodes[arr.length - 1];
            nodes[arr.length / 2 - 1].right = null;
        } else {
            nodes[arr.length / 2 - 1].left = nodes[arr.length - 2];
            nodes[arr.length / 2 - 1].right = nodes[arr.length - 1];
        }
    }

    public static void preOrderTraverse(TreeNode root){
        if (root!=null){
            System.out.print(root.val+" ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    public static void inOrderTraverse(TreeNode root){
        if (root!=null){
            inOrderTraverse(root.left);
            System.out.print(root.val+" ");
            inOrderTraverse(root.right);
        }
    }

    public static void postOrderTraverse(TreeNode root){
        if (root!=null){
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.val+" ");
        }
    }

    public static void main(String[] args) {
        Integer[] arr={1,2,2,3,4,4,3};
        TreeNode[] nodes = new TreeNode[arr.length];
        createTree(arr,nodes);
        System.out.println("前序遍历：");
        preOrderTraverse(nodes[0]);
        System.out.println();
        System.out.println("中序遍历：");
        inOrderTraverse(nodes[0]);
        System.out.println();
        System.out.println("后序遍历：");
        postOrderTraverse(nodes[0]);
    }
}
