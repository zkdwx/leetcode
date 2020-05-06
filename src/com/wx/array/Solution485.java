package com.wx.array;

public class Solution485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] == 0 || i == nums.length - 1) {
                max = Math.max(max, sum);
                sum = 0;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1};
        int x = findMaxConsecutiveOnes(nums);
        System.out.println(x);
    }
}
