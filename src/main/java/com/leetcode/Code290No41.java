package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zz
 */
public class Code290No41 {

    public static boolean wordPattern(String pattern, String s) {
        Map<String, Character> s2pat = new HashMap<>();
        Map<Character, String> pat2s = new HashMap<>();

        int i = 0;
        for (int p = 0; p < pattern.length(); p++) {
            char c = pattern.charAt(p);
            if (i > s.length()) {
                return false;
            }
            int j = i;
            while (j < s.length() && s.charAt(j) != ' ') {
                j++;
            }
            String tmp = s.substring(i, j);
            if (s2pat.containsKey(tmp) && s2pat.get(tmp) != c) {
                return false;
            }
            if (pat2s.containsKey(c) && !Objects.equals(pat2s.get(c), tmp)) {
                return false;
            }
            s2pat.put(tmp, c);
            pat2s.put(c, tmp);
            i = j + 1;
        }
        return i >= s.length();
    }

    public static boolean wordPattern1(String pattern, String s) {
        String[] str = s.split(" ");
        if (pattern.length() != str.length) {
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!Objects.equals(map.put(pattern.charAt(i), i), map.put(str[i], i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba", s = "dog cat cat dog";
        String pattern1 = "ccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccdd"
                , s1 = "s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s s t t";
        System.out.println(wordPattern(pattern1, s1));
        System.out.println(wordPattern1(pattern1, s1));
        System.out.println(practice(pattern1, s1));
    }

    public static boolean practice(String pattern, String s) {
        Map<String, Character> s2pat = new HashMap<>();
        Map<Character, String> pat2s = new HashMap<>();

        int i = 0;
        for (int j = 0; j < pattern.length(); j++) {
            char c = pattern.charAt(j);
            if (i > s.length()) {
                return false;
            }
            int p = i;
            while (p < s.length() && s.charAt(p) != ' ') {
                p++;
            }
            String tmp = s.substring(i, p);
            if (s2pat.containsKey(tmp) && s2pat.get(tmp) != c){
                return false;
            }
            if (pat2s.containsKey(c) && !Objects.equals(pat2s.get(c), tmp)){
                return false;
            }
            s2pat.put(tmp, c);
            pat2s.put(c, tmp);
            i = p + 1;
        }
        return i >= s.length();
    }

}
