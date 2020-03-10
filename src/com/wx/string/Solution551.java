package com.wx.string;
//********************************************************************************************
//        551. Student Attendance Record I
//        Easy
//        You are given a string representing an attendance record for a student. The record only contains the following three characters:
//
//        'A' : Absent.
//        'L' : Late.
//        'P' : Present.
//
//        A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
//
//        You need to return whether the student could be rewarded according to his attendance record.
//
//        Example 1:
//
//        Input: "PPALLP"
//        Output: True
//
//        Example 2:
//
//        Input: "PPALLL"
//        Output: False

//********************************************************************************************
public class Solution551 {
    public static boolean checkRecord(String s) {
        int len = s.length();
        s = s + " "+" ";
        boolean b = false;
        for (int i = 0; i < len; i++) {

            if ((b && s.charAt(i) == 'A') || (s.charAt(i) == 'L' && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')) {
                return Boolean.FALSE;
            }
            if (s.charAt(i) == 'A') {
                b = true;
            }

        }
        return Boolean.TRUE;
    }
    public static void main(String[] args) {
        boolean b = checkRecord("ALL");
        System.out.println(b);
    }
}
