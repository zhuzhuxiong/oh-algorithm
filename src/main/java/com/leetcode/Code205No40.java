package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zz
 */
public class Code205No40 {

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i), tt = t.charAt(i);
            if ((s2t.containsKey(ss) && s2t.get(ss) != tt) || (t2s.containsKey(tt) && t2s.get(tt) != ss)) {
                return false;
            }
            s2t.put(ss,tt);
            t2s.put(tt,ss);
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "egg", t = "add";
        System.out.println(isIsomorphic(s,t));
        System.out.println(practice(s,t));

        String s1 = "foo", t1 = "bar";
        System.out.println(isIsomorphic(s1,t1));
        System.out.println(practice(s1,t1));
    }

    public static boolean practice(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i), tt = t.charAt(i);
            if (s2t.containsKey(ss) && s2t.get(ss) != tt) {
                return false;
            }
            if (t2s.containsKey(tt) && t2s.get(tt) != ss) {
                return false;
            }
            s2t.put(ss,tt);
            t2s.put(tt, ss);
        }
        return true;
    }
}
