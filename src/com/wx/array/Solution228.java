package com.wx.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. 汇总区间
 */
public class Solution228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        if (nums == null || nums.length == 0) return list;
        if (nums.length == 1) {
            list.add(nums[0] + "");
            return list;
        }
        int i = 0;
        int j = 1;
        while (i < nums.length) {
            while (j < nums.length && nums[j - 1] + 1 == nums[j]) {
                j++;
            }
            String s = "";
            if (i == j - 1) {
                s = nums[i] + "";
            } else {
                s = nums[i] + "->" + nums[j - 1];
            }
            list.add(s);
            i = j;
            j++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 7};
//        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        List<String> list = summaryRanges(nums);
        System.out.println(list);
    }
}
