package com.wx.string;
//********************************************************************************************
//        387. First Unique Character in a String
//        Easy
//
//        Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
//
//        Examples:
//
//        s = "leetcode"
//        return 0.
//
//        s = "loveleetcode",
//        return 2.
//
//        Note: You may assume the string contain only lowercase letters.

import java.util.HashMap;
import java.util.Map;

//********************************************************************************************
public class Solution387 {
    public static int firstUniqChar(String s) {
        int len = s.length();
        if (len == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int temp = map.get(c) + 1;
                map.put(c, temp);
            }
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int s = firstUniqChar("aabbccddd");
        System.out.println(s);
    }
}
