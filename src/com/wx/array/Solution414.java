package com.wx.array;
//414. Third Maximum Number
//        Easy
//
//        Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
//
//        Example 1:
//
//        Input: [3, 2, 1]
//
//        Output: 1
//
//        Explanation: The third maximum is 1.
//
//        Example 2:
//
//        Input: [1, 2]
//
//        Output: 2
//
//        Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
//
//        Example 3:
//
//        Input: [2, 2, 3, 1]
//
//        Output: 1
//
//        Explanation: Note that the third maximum here means the third maximum distinct number.
//        Both numbers with value 2 are both considered as second maximum.

public class Solution414 {
    public static int thirdMax(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int first = Integer.MIN_VALUE;
        int thridIndex=-1;
        int second = Integer.MIN_VALUE;
        int thrid = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (nums[i] > first) {
                first = nums[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] > second && nums[i] != first) {
                second = nums[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] >= thrid && nums[i] != first && nums[i] != second) {
                thrid = nums[i];
                thridIndex=i;
            }
        }
        //这里不能用Integer.MIN_VALUE和thrid进行比较，因为数组中可能会包含Integer.MIN_VALUE
        //这样分支就会走错
        if (thridIndex!=-1) {
            return nums[thridIndex];
        }
            return first;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,3,1};
        int x=  thirdMax(nums);
        System.out.println(x);
    }
}
