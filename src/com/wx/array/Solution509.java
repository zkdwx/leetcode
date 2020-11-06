package com.wx.array;

/**
 * 509. 斐波那契数
 */
public class Solution509 {
    public static int fib(int N) {
        if (N <= 1) return N;
        int a = 0;
        int b = 1;
        int res = 0;
        for (int i = 2; i <= N; i++) {
            res = a + b;
            a = b;
            b = res;
        }
        return res;
    }

    public static void main(String[] args) {
        int i = fib(4);
        System.out.println(i);
    }
}
