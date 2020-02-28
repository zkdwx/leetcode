package com.wx.string;
//********************************************************************************************
//        415. Add Strings
//        Easy
//
//        Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
//
//        Note:
//
//        The length of both num1 and num2 is < 5100.
//        Both num1 and num2 contains only digits 0-9.
//        Both num1 and num2 does not contain any leading zero.
//        You must not use any built-in BigInteger library or convert the inputs to integer directly.

//********************************************************************************************
public class Solution415 {
    public static String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuilder sb = new StringBuilder();
        int i = len1 - 1;
        int j = len2 - 1;
        int jinwei = 0;
        while (i >= 0 && j >= 0) {
            int a = num1.charAt(i) - '0';
            int b = num2.charAt(j) - '0';
            int temp = jinwei + a + b;
            jinwei = temp / 10;
            sb.append(temp % 10);
            i--;
            j--;
        }
        while (i >= 0) {
            if (jinwei > 0) {
                int a = num1.charAt(i) - '0';
                int temp = jinwei + a;
                jinwei = temp / 10;
                sb.append(temp % 10);
                i--;
            } else {
                StringBuilder tempSb = new StringBuilder(num1.substring(0, i + 1));
                sb.append(tempSb.reverse().toString());
                break;
            }
        }
        while (j >= 0) {
            if (jinwei > 0) {
                int b = num2.charAt(j) - '0';
                int temp = jinwei + b;
                jinwei = temp / 10;
                sb.append(temp % 10);
                j--;
            } else {
                StringBuilder tempSb = new StringBuilder(num2.substring(0, j + 1));
                sb.append(tempSb.reverse().toString());
                break;
            }
        }
        if (jinwei > 0) {
            sb.append(1);
        }
        return sb.reverse().toString();

    }


    public static void main(String[] args) {
        String num1 = "9133";
        String num2 = "0";
        String s = addStrings(num1, num2);
        System.out.println(s);
    }
}
