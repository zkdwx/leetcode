package com.wx.string;
//********************************************************************************************
//        459. Repeated Substring Pattern
//        Easy
//
//        Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
//
//
//
//        Example 1:
//
//        Input: "abab"
//        Output: True
//        Explanation: It's the substring "ab" twice.
//
//        Example 2:
//
//        Input: "aba"
//        Output: False
//
//        Example 3:
//
//        Input: "abcabcabcabc"
//        Output: True
//        Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
//
//********************************************************************************************
public class Solution459 {
    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int i=len/2;
        while (i>=1){
            if (len%i==0){
                int a=len/i;
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < a; j++) {
                    sb.append(s.substring(0,i+1));
                }
                if (sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        boolean b = repeatedSubstringPattern("abab");
        System.out.println(b);
    }
}
