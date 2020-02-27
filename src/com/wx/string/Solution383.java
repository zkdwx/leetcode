package com.wx.string;
import java.util.HashMap;
import java.util.Map;
////********************************************************************************************
////      383. Ransom Note

//        Easy

//        Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
//
//        Each letter in the magazine string can only be used once in your ransom note.
//
//        Note:
//        You may assume that both strings contain only lowercase letters.
//
//        canConstruct("a", "b") -> false
//        canConstruct("aa", "ab") -> false
//        canConstruct("aa", "aab") -> true
//********************************************************************************************
public class Solution383 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        int noteLen = ransomNote.length();
        if (noteLen == 0) return true;
        Map<Character, Integer> noteMap = countChar(ransomNote);
        Map<Character, Integer> magMap = countChar(magazine);
        for (int i = 0; i < noteLen; i++) {
            char c = ransomNote.charAt(i);
            int a = noteMap.get(c);
            if (!magMap.containsKey(c) || a > magMap.get(c))
                return false;
        }
        return true;
    }

    private static Map<Character, Integer> countChar(String s) {
        int len = s.length();
        Map<Character, Integer> noteMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char notec = s.charAt(i);
            if (noteMap.get(notec) == null) {
                noteMap.put(notec, 1);
            } else {
                int temp = noteMap.get(notec) + 1;
                noteMap.put(notec, temp);
            }
        }
        return noteMap;
    }


    public static void main(String[] args) {
        boolean b = canConstruct("aa", "aab");
        System.out.println(b);

    }
}
