package com.wx.array;

public class Solution747 {
    public static int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        for (int i = 0; i < nums.length ; i++) {
            if (i == index) continue;
            if (nums[index] >> 1 < nums[i]) {
                return -1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 3, 2};
        dominantIndex(nums);
    }
}
