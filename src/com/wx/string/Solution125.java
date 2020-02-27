package com.wx.string;
//********************************************************************************************
//        125. Valid Palindrome
//        Easy
//
//        Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//        Note: For the purpose of this problem, we define empty string as valid palindrome.
//
//        Example 1:
//
//        Input: "A man, a plan, a canal: Panama"
//        Output: true
//
//        Example 2:
//
//        Input: "race a car"
//        Output: false
//********************************************************************************************
public class Solution125 {
    public static boolean isPalindrome(String s) {
        int len = s.length();
        if (len == 0 || len == 1) return true;
        char[] c = new char[len];
        int j = 0;
        s = s.toLowerCase();
        for (int i = 0; i < len; i++) {
            char cc = s.charAt(i);
            if (('a' <= cc && cc <= 'z') || Character.isDigit(cc)) {
                c[j++] = cc;
            }
        }
        if (j==0) return true;
        for (int i = 0; i <= (j - 1) / 2; i++) {
            if (c[i] != c[j - i - 1]) {
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        boolean b = isPalindrome("0P");
        System.out.println(b);
    }
}
