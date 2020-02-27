package com.wx.string;
//********************************************************************************************
//        344. Reverse String
//        Easy
//
//        Write a function that reverses a string. The input string is given as an array of characters char[].
//
//        Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//
//        You may assume all the characters consist of printable ascii characters.
//
//
//
//        Example 1:
//
//        Input: ["h","e","l","l","o"]
//        Output: ["o","l","l","e","h"]
//
//        Example 2:
//
//        Input: ["H","a","n","n","a","h"]
//        Output: ["h","a","n","n","a","H"]


//********************************************************************************************
public class Solution344 {
    public static void reverseString(char[] s) {
        int len = s.length;
        if (len == 0) return;
        for (int i = 0; i < len / 2; i++) {
            char temp;
            temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'a', 'd', 'f', 's', 'e', 't'};
        reverseString(s);
    }
}
