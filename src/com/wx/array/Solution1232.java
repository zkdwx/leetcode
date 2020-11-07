package com.wx.array;

/**
 * 1232. 缀点成线
 */
public class Solution1232 {
    public static boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        if (coordinates[1][0] == coordinates[0][0]) {
            for (int i = 2; i < coordinates.length; i++) {
                int[] arr = coordinates[i];
                if (arr[0] != coordinates[0][0]) {
                    return false;
                }
            }
            return true;
        }
        double k = (coordinates[1][1] - coordinates[0][1]) / (double)(coordinates[1][0] - coordinates[0][0]);
        int[] first = coordinates[0];
        for (int i = 2; i < coordinates.length; i++) {
            int[] arr = coordinates[i];
            if ((arr[1] - first[1]) != k * (arr[0] - first[0])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = {{2, 1}, {4, 2}, {6, 3}};
        boolean b = checkStraightLine(coordinates);
        System.out.println(b);
    }
}
