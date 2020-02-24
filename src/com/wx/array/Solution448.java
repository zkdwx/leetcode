//****************************************************************************************************
//        448. Find All Numbers Disappeared in an Array
//        Easy
//
//        Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
//
//        Find all the elements of [1, n] inclusive that do not appear in this array.
//
//        Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
//
//        Example:
//
//        Input:
//        [4,3,2,7,8,2,3,1]
//
//        Output:
//        [5,6]
//*******************************************************************************************************

        package com.wx.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution448 {
    //方案1
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return list;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], i);
        }
        for (int i = 1; i <= len; i++) {
            if (!map.containsKey(i)) {
                list.add(i);
            }
        }
        return list;
    }

    //方案2
    // faster than 100.00%
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int len = nums.length;
        if (len == 0) return list;
        boolean[] flag = new boolean[len + 1];
        for (int i = 0; i < len; i++) {
            flag[nums[i]] = true;
        }
        for (int i = 1; i < flag.length; i++) {
            if (!flag[i]) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDisappearedNumbers2(nums);
        for (int a : list)
            System.out.println(a);
    }
}
