package com.leetcode.classic150;

/**
 * todo dp
 * @author
 */
public class No26Code392 {

    public static boolean isSubsequence(String s, String t) {
        int p1 = 0, p2 = 0;
        int sl = s.length(), tl = t.length();
        while (p1 < sl && p2 < tl) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
                p2++;
            }else {
                p2++;
            }
        }
        if (p1 == sl){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }

    public static boolean practice(String s, String t) {
        int m = s.length(), n = t.length();
        int p1 = 0, p2 = 0;
        while (p1 < m && p2 < n) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
                p2++;
            }else {
                p2++;
            }
        }
        if (p1 == m) {
            return true;
        }
        return false;
    }
}
