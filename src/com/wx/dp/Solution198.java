package com.wx.dp;

//********************************************************************************************
//        198. House Robber
//        Easy
//
//        You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
//        Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
//
//        Example 1:
//
//        Input: [1,2,3,1]
//        Output: 4
//        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//        Total amount you can rob = 1 + 3 = 4.
//
//        Example 2:
//
//        Input: [2,7,9,3,1]
//        Output: 12
//        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
//        Total amount you can rob = 2 + 9 + 1 = 12.
//********************************************************************************************
public class Solution198 {

    //递归
    public static int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return maxMoney(nums.length - 1, nums, dp);

    }

    public static int maxMoney(int index, int[] nums, int[] dp) {
        if (index < 0) return 0;
        if (dp[index] >= 0) {
            return dp[index];
        }
        dp[index] = Math.max(nums[index] + maxMoney(index - 2, nums, dp), maxMoney(index - 1, nums, dp));
        return dp[index];
    }

    //递推
    public static int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int index = 2; index < nums.length; index++) {
            dp[index] = Math.max(nums[index] + dp[index - 2], dp[index - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200,
                91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195,
                187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78,
                188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
//        int[] nums = {1, 2, 3, 1};
        int x = rob2(nums);
        System.out.println(x);

    }
}
