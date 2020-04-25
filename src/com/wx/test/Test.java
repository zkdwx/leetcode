package com.wx.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s= sc.nextLine();
        String[] arr=s.split(" ");
        int[] a=new int[arr.length];
        for (int i = 0; i < a.length; i++) {
            a[i]=Integer.parseInt(arr[i]);
        }
    }
}
