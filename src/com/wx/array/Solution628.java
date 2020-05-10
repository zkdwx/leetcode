package com.wx.array;

import java.util.Arrays;

public class Solution628 {
    public static int maximumProduct(int[] nums) {
        int len = nums.length;
        if (len < 3) return 0;
        Arrays.sort(nums);
        int start = nums[0] * nums[1];
        int end = nums[len - 1] * nums[len - 2];
        int max1=Math.max(start*nums[len-1],start*nums[2]);
        int max2 = Math.max(end*nums[0],end*nums[len-3]);
        return Math.max(max1,max2);
    }

    public static void main(String[] args) {
        int[] nums = {-4, -3, -2, -1, 60};
        int x = maximumProduct(nums);
        System.out.println(x);
    }
}
