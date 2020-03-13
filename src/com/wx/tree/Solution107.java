package com.wx.tree;

import java.util.*;
//********************************************************************************************
//        107. Binary Tree Level Order Traversal II
//        Easy
//
//        Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
//
//        For example:
//        Given binary tree [3,9,20,null,null,15,7],
//
//        3
//        / \
//        9  20
//        /  \
//        15   7
//
//        return its bottom-up level order traversal as:
//
//        [
//        [15,7],
//        [9,20],
//        [3]
//        ]
//********************************************************************************************
public class Solution107 {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = queue.size();
        List<Integer> tempList = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (i == 0) {
                list.add(tempList);
                i = queue.size();
                tempList = new ArrayList<>();
            }
            TreeNode tempNode = queue.poll();
            tempList.add(tempNode.val);
            i--;
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
        list.add(tempList);
        Collections.reverse(list);
        return list;

    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();

        levelRecursion(root, result, 0);

        return result;
    }

    /**
     * 递归方法
     */
    private void levelRecursion(TreeNode node,
                                LinkedList<List<Integer>> result, int level) {
        if (node == null) {
            return;
        }
        if (result.size() < level + 1) {// 说明还需要添加一行
            result.addFirst(new ArrayList<Integer>());
        }
        result.get(result.size() - 1 - level).add(node.val);

        levelRecursion(node.left, result, level + 1);
        levelRecursion(node.right, result, level + 1);
    }


    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        Integer[] arr = {1, 2, 3, 4, 5, 6};
        TreeNode[] nodes = new TreeNode[arr.length];
        tree.createTree(arr, nodes);
        List<List<Integer>> list = levelOrderBottom(nodes[0]);


        System.out.println("前序遍历：");
        tree.preOrderTraverse(nodes[0]);

    }
}
