package com.wx.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution532 {
    public static int findPairs(int[] nums, int k) {
        if (nums.length <= 1 || k < 0) return 0;
        int count = 0;
        if (k != 0) {
            Set<Integer> set = new HashSet<>();
            for (int x : nums) {
                set.add(x);
            }
            for (int x : set) {
                int temp = x + k;
                if (set.contains(temp)) {
                    count++;
                }
            }
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : nums) {
                if (map.containsKey(x)) {
                    int temp = map.get(x) + 1;
                    map.put(x, temp);
                } else {
                    map.put(x, 1);
                }
            }
            for (int x : map.keySet()) {
                if (map.get(x) > 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 5, 4};
        int x = findPairs(nums, 0);
        System.out.println(x);
    }
}
