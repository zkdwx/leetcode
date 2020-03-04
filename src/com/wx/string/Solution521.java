package com.wx.string;
//********************************************************************************************
//        521. Longest Uncommon Subsequence I
//        Easy
//
//        Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings. The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence should not be any subsequence of the other strings.
//
//        A subsequence is a sequence that can be derived from one sequence by deleting some characters without changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an empty string is a subsequence of any string.
//
//        The input will be two strings, and the output needs to be the length of the longest uncommon subsequence. If the longest uncommon subsequence doesn't exist, return -1.
//
//        Example 1:
//
//        Input: "aba", "cdc"
//        Output: 3
//        Explanation: The longest uncommon subsequence is "aba" (or "cdc"),
//        because "aba" is a subsequence of "aba",
//        but not a subsequence of any other strings in the group of two strings.
//
//        Note:
//
//        Both strings' lengths will not exceed 100.
//        Only letters from a ~ z will appear in input strings.

//********************************************************************************************
public class Solution521 {
//    想了半天，原来是脑筋急转弯，如果两个元素不等长，那么其中长字符本身就不是另一个字符的子序列，
//    输出长度就行，如果等长，那么如果两个字符串相同，返回-1，不同返回长度，因为一个不是另一个的子序列。
//    就是说如果两个字符串相同就返回-1，不同就返回最长的
    public static int findLUSlength(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if (aLen > bLen) {
            return aLen;
        } else if (aLen < bLen) {
            return bLen;
        } else {
            if (a.equals(b)) {
                return -1;
            } else {
                return aLen;
            }
        }
    }

    //方案2（只是写法简洁点）
    public int findLUSlength2(String a, String b) {
        return a.equals(b)?-1:Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        int s = findLUSlength("","d");
        System.out.println(s);
    }
}
