package com.wx.array;

/**
 * 88. 合并两个有序数组
 * 最后一个循环要加的意义是i执行到了0位置j没有，后面只需要把j前面的值赋值给第一个数组即可
 */
public class Solution88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j];
                j--;
            } else if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i];
                i--;
            } else {
                nums1[k--] = nums1[i];
                nums1[k--] = nums2[j];
                i--;
                j--;
            }
        }
        for (int l = 0; l <= j; l++) {
            nums1[l] = nums2[l];
        }

    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int m = 3;
//        int[] nums2 = {2, 5, 6};
//        int n = 3;

        int[] nums1 = {2, 0};
        int m = 1;
        int[] nums2 = {1};
        int n = 1;

        merge(nums1, m, nums2, n);
        for (int x : nums1) {
            System.out.print(x + " ");
        }
    }
}
