package com.wx.array;

public class Solution605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        if (len == 1) {
            if (flowerbed[0] == 0) {
                return 1 >= n;
            } else {
                return 0 >= n;
            }
        }
        int count = 0;
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            count++;
            flowerbed[0] = 1;
        }

        if (flowerbed[len - 1] == 0 && flowerbed[len - 2] == 0) {
            count++;
            flowerbed[len - 1] = 1;
        }
        for (int i = 1; i < len - 1; i++) {
            if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                count++;
                flowerbed[i] = 1;
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 0, 1, 0, 1};
        System.out.println(canPlaceFlowers(nums, 1));

    }
}
