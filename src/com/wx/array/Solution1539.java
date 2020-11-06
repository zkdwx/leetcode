package com.wx.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1539. 第 k 个缺失的正整数
 */
public class Solution1539 {
    public static int findKthPositive(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        List<Integer> arrList = new ArrayList<>(arr.length);
        for (int x : arr) {
            arrList.add(x);
        }
        for (int i = 1; i < arr[arr.length - 1]; i++) {
            if (!arrList.contains(i)) {
                list.add(i);
            }
        }
        if (k <= list.size()) {
            return list.get(k - 1);
        } else {
            return k - list.size() + arr[arr.length - 1];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2};
        int k = 1;
        int i = findKthPositive(arr, k);
        System.out.println(i);
    }
}
