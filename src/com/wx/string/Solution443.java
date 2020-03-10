package com.wx.string;
//********************************************************************************************
//        443. String Compression
//        Easy
//
//        Given an array of characters, compress it in-place.
//
//        The length after compression must always be smaller than or equal to the original array.
//
//        Every element of the array should be a character (not int) of length 1.
//
//        After you are done modifying the input array in-place, return the new length of the array.
//
//
//        Follow up:
//        Could you solve it using only O(1) extra space?
//
//
//        Example 1:
//
//        Input:
//        ["a","a","b","b","c","c","c"]
//
//        Output:
//        Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
//
//        Explanation:
//        "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
//
//
//
//        Example 2:
//
//        Input:
//        ["a"]
//
//        Output:
//        Return 1, and the first 1 characters of the input array should be: ["a"]
//
//        Explanation:
//        Nothing is replaced.
//
//
//
//        Example 3:
//
//        Input:
//        ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
//
//        Output:
//        Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
//
//        Explanation:
//        Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
//        Notice each digit has it's own entry in the array.
//
//
//
//        Note:
//
//        All characters have an ASCII value in [35, 126].
//        1 <= len(chars) <= 1000.


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//********************************************************************************************
public class Solution443 {
    public static int compress(char[] chars) {
        int len = chars.length;
        if (len==0) return 0;
        int k=0; //指向遍历不同字母的指针
        int m=0;  //指向重新给chars数组赋值的指针
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(chars[i])){
                map.put(chars[i],1);
            }
            else {
                int temp = map.get(chars[i])+1;
                map.put(chars[i],temp);
            }
        }
        while (k<len-1){
            int count = map.get(chars[k]);
            m++;
            if (count>1){
                String countStr =count+"";
                for (int i = 0; i < countStr.length(); i++) {
                    chars[m++]=countStr.charAt(i);
                }
                while (chars[k]==chars[k+1]){
                    k++;
                }

            }
        }

        return m+1;
    }

    public static void main(String[] args) {
        char[] chars={'a','a','b','b','c','c','c'};
        int a = compress(chars);
        System.out.println(a);
        Map map= Collections.synchronizedMap(new HashMap<>());

    }
}
