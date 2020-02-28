package com.wx.string;

//********************************************************************************************
//        434. Number of Segments in a String
//        Easy
//
//        Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
//
//        Please note that the string does not contain any non-printable characters.
//
//        Example:
//
//        Input: "Hello, my name is John"
//        Output: 5
//********************************************************************************************
public class Solution434 {
    public static int countSegments(String s) {
        s = s + " ";       //由于判断的标准是前一个字符非空格，后一个字符是空格，所以为了统一处理最后一个字符串，在后面补上一个空格
        int len = s.length();
        if (len == 1) return 0;
        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            if (c1 != ' ' && c2 == ' ') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int s = countSegments("Hello, my name is John");
        System.out.println(s);
    }
}
