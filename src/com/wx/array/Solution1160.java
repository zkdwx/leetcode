package com.wx.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1160. 拼写单词
 */
public class Solution1160 {
    public static int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
        }

        for (String s : words) {
            boolean b = true;
            Map<Character, Integer> tmpMap = new HashMap<>(map);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!tmpMap.containsKey(c)) {
                    b = false;
                    break;
                }
                int count = tmpMap.get(c) - 1;
                tmpMap.put(c, count);
                if (count < 0) {
                    b = false;
                    break;
                }
            }
            if (b) {
                res += s.length();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        int i = countCharacters(words, chars);
        System.out.println(i);
    }
}
