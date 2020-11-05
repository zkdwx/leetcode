package com.wx.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1331. 数组序号转换
 */
public class Solution1331 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return arr;
        int[] res = new int[arr.length];
        Set<Integer> set = new TreeSet<>();
        for (int x : arr) {
            set.add(x);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int i = 1;
        for (int x : set) {
            map.put(x, i++);
        }
        for (int j = 0; j < arr.length; j++) {
            res[j] = map.get(arr[j]);
        }
        return res;
    }
}
