package com.wx.string;
//********************************************************************************************
//        557. Reverse Words in a String III
//        Easy
//
//        Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
//        Example 1:
//
//        Input: "Let's take LeetCode contest"
//        Output: "s'teL ekat edoCteeL tsetnoc"
//
//        Note: In the string, each word is separated by single space and there will not be any extra space in the string.
//********************************************************************************************
public class Solution557 {
    public static String reverseWords(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        int i = 0;
        while (i < len) {
            while (i < len && chars[i] == ' ') {
                i++;
            }
            int j = i;
            while (j < len && chars[j] != ' ') {
                j++;
            }
            swap(chars, i, j - 1);
            i=j;
        }
        return String.valueOf(chars);
    }

    private static void swap(char[] chars, int i, int j) {
        while (i < j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String s = reverseWords("Lq");
//        String s = reverseWords("Let's take");
        System.out.println(s);
    }
}
