package com.wx.string;


public class Solution686 {
    public static int repeatedStringMatch(String A, String B) {
        int aLen = A.length();
        int bLen = B.length();
        if (A.contains(B)) return 1;
        StringBuilder sb = new StringBuilder(A);
        int time=1;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sb.append(A);
            time++;
            if (sb.toString().contains(B)){
                return time;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("aa","a"));
    }
}
