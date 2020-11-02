package com.wx.array;

/**
 * 1588. 所有奇数长度子数组的和
 */
public class Solution1588 {
    public static int sumOddLengthSubarrays(int[] arr) {
        int count = 0;
        for (int i = 1; i <= arr.length; i += 2) {
            int start = 0;
            while (start + i <= arr.length) {
                for (int j = start; j < start + i; j++) {
                    count += arr[j];
                }
                start++;
            }

        }
        return count;
    }

    public static void main(String[] args) {
//        int[] arr = {1, 4, 2, 5, 3};
        int[] arr = {10,11,12};
        int i = sumOddLengthSubarrays(arr);
        System.out.println(i);
    }
}
