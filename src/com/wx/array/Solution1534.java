package com.wx.array;

/**
 * 1534. 统计好三元组
 */
public class Solution1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (isGood(arr[i], arr[j], arr[k], a, b, c)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean isGood(int x, int y, int z, int a, int b, int c) {
        return (Math.abs(x - y) <= a && Math.abs(y - z) <= b && Math.abs(x - z) <= c);
    }

}
