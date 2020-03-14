package com.wx.tree;

/**
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     public TreeNode(int x) {
 *         val = x;
 *     }
 * }
 *
 * public class LinkNode {
 *     int val;
 *     LinkNode next;
 *
 *     LinkNode(int val) {
 *         this.val = val;
 *     }
 * }
 *
 */
public class Test {
    // 二叉搜索树转换成双向链表
    public static TreeNode biSearchTreeToBidirectionlinkList(TreeNode head){
        if(head == null)
            return null;
        TreeNode tail = bstTolist(head);
        head = tail.right;
        tail.right = null;
        return head;
    }

    // 二叉搜索树转换成双向链表的递归函数
    public static TreeNode bstTolist(TreeNode head){
        if(head == null)
            return null;

        TreeNode leftE = bstTolist(head.left);
        TreeNode rightE = bstTolist(head.right);
        TreeNode leftS = leftE.right;
        TreeNode rightS = rightE.right;

        if(leftE!=null && rightE!=null){
            leftE.right = head;
            head.left = leftE;
            rightS.left = head;
            head.right = rightS;
            rightE.right = leftS;
            return rightE;
        }
        else if(leftE != null){
            leftE.right = head;
            head.left = leftE;
            head.right = leftS;
            return head;
        }
        else if(rightE != null){
            rightS.left = head;
            head.right = rightS;
            rightE.right = leftS;
            return rightE;
        }
        else{
            head.right = head;
            return head;
        }
    }

    //双向链表转换成二叉搜索树
    public static TreeNode sortListToBstTree(LinkNode head) {
        int size = 0;
        LinkNode cur = head;
        while (cur!=null){
            size++;
            cur=cur.next;
        }
        cur=head;
        LinkNode linkNode=head;
        return crteatBST(linkNode,size);
    }

    private static TreeNode crteatBST(LinkNode linkNode, int size) {
        if (size==0) return null;
        TreeNode head =new TreeNode(0);
        head.left=crteatBST(linkNode,size/2);
        head.val=linkNode.val;
        linkNode=linkNode.next;
        head.right=crteatBST(linkNode,size-size/2-1);
        return head;
    }
}
