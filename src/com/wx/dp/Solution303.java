package com.wx.dp;

//********************************************************************************************
//        303. Range Sum Query - Immutable
//        Easy
//
//        Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
//
//        Example:
//
//        Given nums = [-2, 0, 3, -5, 2, -1]
//
//        sumRange(0, 2) -> 1
//        sumRange(2, 5) -> -1
//        sumRange(0, 5) -> -3
//
//        Note:
//
//        You may assume that the array does not change.
//        There are many calls to sumRange function.

//********************************************************************************************
public class Solution303 {
    int[] dp;

    public Solution303(int[] nums) {
        if (nums.length==0) return;
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (dp.length == 0) return 0;
        if (i == 0) return dp[j];
        return (dp[j] - dp[i - 1]);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        Solution303 obj = new Solution303(nums);
        int param_1 = obj.sumRange(1, 2);
        System.out.println(param_1);
    }
}
