package com.wx.string;
//********************************************************************************************
//        541. Reverse String II
//        Easy
//
//        Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
//
//        Example:
//
//        Input: s = "abcdefg", k = 2
//        Output: "bacdfeg"
//
//        Restrictions:
//
//        The string consists of lower English letters only.
//        Length of the given string and k will in the range [1, 10000]

//********************************************************************************************
public class Solution541 {
    public static String reverseStr(String s, int k) {
        int len = s.length();
        int i = 0;
        char[] chars = s.toCharArray();
        while (i < len) {
            int j = Math.min(i + k - 1, len - 1);
            swap(chars, i, j);
            i += (2 * k);
        }
        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int a, int b) {
        while (a < b) {
            char c = chars[a];
            chars[a] = chars[b];
            chars[b] = c;
            a++;
            b--;
        }
    }
    public static void main(String[] args) {
        String s = reverseStr("abcdefg", 2);
        System.out.println(s);
    }
}
