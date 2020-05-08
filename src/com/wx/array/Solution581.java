package com.wx.array;

import java.util.Arrays;

public class Solution581 {
    public static int findUnsortedSubarray(int[] nums) {
        int preCount = 0;     //从前遍历计算位置没没变的个数
        int lastCount = 0;     //从后遍历计算位置没没变的个数
        boolean pre = true;   //从前遍历，如果不等就置为false
        boolean last = true;  //从前遍历，如果不等就置为false
        if (nums.length <= 1) return 0;
        int[] arr = new int[nums.length];
        System.arraycopy(nums, 0, arr, 0, nums.length);
        Arrays.sort(arr);
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] == nums[i] && pre) {
                preCount++;
            } else {
                pre = false;
            }
            if (arr[arr.length - 1 - i] == nums[nums.length - 1 - i] && last) {
                lastCount++;
            } else {
                last = false;
            }
        }
        int len = nums.length - preCount - lastCount;
        return len > 0 ? len : 0;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int x = findUnsortedSubarray(nums);
        System.out.println(x);
    }
}
