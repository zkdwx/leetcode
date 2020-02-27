package com.wx.string;
//********************************************************************************************
//        345. Reverse Vowels of a String
//        Easy
//
//        Write a function that takes a string as input and reverse only the vowels of a string.
//
//        Example 1:
//
//        Input: "hello"
//        Output: "holle"
//
//        Example 2:
//
//        Input: "leetcode"
//        Output: "leotcede"
//
//        Note:
//        The vowels does not include the letter "y".

//********************************************************************************************
public class Solution345 {
    public static String reverseVowels(String s) {
        int len = s.length();
        char[] c = s.toCharArray();
        int i = 0;
        int j = len - 1;
        while (i < j) {

            if (!isVowels(c[i])) {
                i++;
            }
            if (!isVowels(c[j])) {
                j--;
            }
            if (isVowels(c[i]) && isVowels(c[j])) {
                char temp = c[i];
                c[i] = c[j];
                c[j] = temp;
                i++;
                j--;
            }
        }
        return String.valueOf(c);
    }
    private static boolean isVowels(char c) {
        if (Character.isUpperCase(c)) {
            c = (char) (c + 32);
        }
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String r = reverseVowels("leetcode");
        System.out.println(r);

    }
}
