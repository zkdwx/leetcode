package com.wx.tree;

import com.sun.javafx.collections.MappingChange;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    //创建二叉树
    public static void createTree(Integer[] arr, TreeNode[] nodes) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=null)
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

    //递归
    public static void preOrderTraverse(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preOrderTraverse(root.left);
            preOrderTraverse(root.right);
        }
    }

    //非递归
    public static void preOrderTraverseNoRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) break;
            TreeNode node = stack.pop();
            root = node.right;
        }
    }

    //递归
    public static void inOrderTraverse(TreeNode root) {
        if (root != null) {
            inOrderTraverse(root.left);
            System.out.print(root.val + " ");
            inOrderTraverse(root.right);
        }
    }

    //非递归
    public static void inOrderTraverseNoRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty()) break;
            TreeNode node = stack.pop();
            System.out.print(node.val + " ");
            root = node.right;
        }
    }


    //递归
    public static void postOrderTraverseNoRecursion(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty())
                    return;
                if (stack.lastElement().right == null) {
                    root = stack.pop();
                    System.out.print(root.val + " ");
                    while (root == stack.lastElement().right) {
                        System.out.print(stack.lastElement().val + " ");
                        root = stack.pop();
                        if (stack.isEmpty()) break;
                    }
                }
                if (!stack.isEmpty()) {
                    root = stack.lastElement().right;
                } else {
                    root = null;
                }
            }
        }
    }

    //非递归
    public static void postOrderTraverse(TreeNode root) {
        if (root != null) {
            postOrderTraverse(root.left);
            postOrderTraverse(root.right);
            System.out.print(root.val + " ");
        }
    }

    //层次遍历
    public static void levelOrder(TreeNode root) {
        TreeNode temp;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                queue.offer(temp.left);
            }
            if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    //清空二叉树

    /**
     * 二叉树的清空：
     * 首先提供一个清空以某个节点为根节点的子树的方法，既递归地删除每个节点；
     * 接着提供一个删除树的方法，直接通过第一种方法删除到根节点即可
     */
    public static void clear(TreeNode node) {
        if (node != null) {
            clear(node.left);
            clear(node.right);
            node = null;       //删除节点
        }
    }

    //判断二叉树是否为空
    public static boolean isEmpty(TreeNode root) {
        return root == null;
    }

    //求二叉树的高度
    public static int heigh(TreeNode root) {
        if (root == null) return 0;
        return Math.max(heigh(root.left), heigh(root.right)) + 1;
    }

    //求二叉树的节点数
    public static int size(TreeNode root) {
        if (root == null) return 0;
        return size(root.left)+size(root.right)+1;
    }


    //main方法
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 3, 4, 4, 3};
        TreeNode[] nodes = new TreeNode[arr.length];
        createTree(arr, nodes);

        System.out.println("前序遍历--递归>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        preOrderTraverse(nodes[0]);

        System.out.println();
        System.out.println("前序遍历--非递归>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        preOrderTraverseNoRecursion(nodes[0]);

        System.out.println();
        System.out.println("中序遍历--递归>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        inOrderTraverse(nodes[0]);

        System.out.println();
        System.out.println("中序遍历--非递归>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        inOrderTraverseNoRecursion(nodes[0]);

        System.out.println();
        System.out.println("后序遍历--递归>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        postOrderTraverse(nodes[0]);

        System.out.println();
        System.out.println("后序遍历--非递归>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        postOrderTraverseNoRecursion(nodes[0]);

        System.out.println();
        System.out.println("层序遍历>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        levelOrder(nodes[0]);

//        System.out.println();
//        System.out.println("二叉树的清空>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//        clear(nodes[0]);

        System.out.println();
        System.out.println("求二叉树的高度>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(heigh(nodes[0]));

        System.out.println();
        System.out.println("求二叉树的节点数>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        System.out.println(size(nodes[0]));
    }
}
