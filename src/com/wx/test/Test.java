package com.wx.test;

public class Test {
    public int findSimilar(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int[][] dp = new int[aLen + 1][bLen + 1];
        for (int i = 0; i < aLen; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < bLen; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= aLen; i++) {
            for (int j = 1; j <= bLen; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }
        return dp[aLen][bLen] / 2;
    }

    private void move(char[] chars, int i, int j) {
        char temp = chars[i];
        for (int k = i; k < j; k++) {
            chars[i] = chars[i + 1];
        }
        chars[j] = temp;
    }
}
