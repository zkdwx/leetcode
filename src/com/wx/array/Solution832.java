package com.wx.array;

/**
 * 832. 翻转图像
 * 注意数据长度的奇偶性，翻转时可能少翻或者多翻
 * ^ 异或，相同为0，不同为1
 * 1^1=0  1^0=0
 */
public class Solution832 {
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] arr = A[i];
            reverse(arr);
        }
        return A;
    }

    private static void reverse(int[] arr) {
        int len = arr.length;
        int limit;
        if (len % 2 == 0) {
            limit = len / 2 - 1;
        } else {
            limit = len / 2;
        }
        for (int i = 0; i <= limit; i++) {
            int tmp = arr[i];
            arr[i] = arr[arr.length - 1 - i] ^ 1;
            arr[arr.length - i - 1] = tmp ^ 1;
        }
    }

    public static void main(String[] args) {
        int[][] A = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        flipAndInvertImage(A);
    }
}
