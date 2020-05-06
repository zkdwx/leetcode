package com.wx.array;

import java.util.Arrays;

public class Solution561 {
    public static int arrayPairSum(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum+=nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,2};
        int x = arrayPairSum(nums);
        System.out.println(x);

    }
}
