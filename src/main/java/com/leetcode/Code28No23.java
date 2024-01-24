package com.leetcode;

/**
 * 字符串第一个匹配下标
 * @author zz
 */
public class Code28No23 {

    public static int strStr(String haystack, String needle) {
        int m  = haystack.length();
        int n  = needle.length();

        for (int i = 0; i + n <= m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i+j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }

        return  -1;
    }

    public static int strStr1(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int n = haystack.length();
        int m = needle.length();
        haystack = " " + haystack;
        needle = " " + needle;

        char[] hh = haystack.toCharArray();
        char[] nn = needle.toCharArray();

        int[] next = new int[m+1];
        for (int i = 2, j = 0; i <= m; i++) {
            while (j > 0 && nn[i] != nn[j+1]) {
                j = next[j];
            }
            if (nn[i] == nn[j+1]) {
                j++;
            }
            next[i] = j;
        }

        for (int i = 1, j = 0; i <= n; i++) {
            while (j > 0 && hh[i] != nn[j+1]){
                j = next[j];
            }
            if (hh[i] == nn[j+1]) {
                j++;
            }
            if (j == m) {
                return  i - m;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        String hayStack = "sadbutsad"; String needle = "sad";
        String hayStack1 = "a"; String needle1 = "a";
        System.out.println(strStr(hayStack, needle));
        System.out.println(strStr(hayStack1, needle1));

        System.out.println(strStr1(hayStack, needle));
        System.out.println(strStr1(hayStack1, needle1));

        System.out.println(practice(hayStack, needle));
        System.out.println(practice(hayStack1, needle1));
    }

    public static int practice(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i + n <= m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
