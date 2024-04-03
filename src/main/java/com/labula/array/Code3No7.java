package com.labula.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 */
public class Code3No7 {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int res = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            res = Math.max(res, right - left);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring1(s));
    }

    public static String lengthOfLongestSubstring1(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0, start = 0;
        ArrayList<String> list = new ArrayList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            window.put(c, window.getOrDefault(c, 0) + 1);

            while (window.get(c) > 1) {
                start = left;
                char d = s.charAt(left);
                left++;
                window.put(d, window.get(d) - 1);
            }
            list.add(s.substring(start, right - 1));
        }
        int len = 0;
        String res = "";
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() > len) {
                len = list.get(i).length();
                res = list.get(i);
            }
        }
        return res;
    }

    public static int practice(String s) {
        return 0;
    }
}
