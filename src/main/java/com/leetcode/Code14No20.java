package com.leetcode;

/**
 * 字符串最长公共前缀
 *
 * @author zz
 */
public class Code14No20 {

    /**
     * 横向对比
     */
    public static String longestCommonPrefix(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int length = Math.min(pre.length(), strs[i].length());
            int index = 0;
            while (index < length && pre.charAt(index) == strs[i].charAt(index)) {
                index++;
            }
            pre = pre.substring(0, index);
            if (pre.length() == 0) {
                break;
            }
        }
        return pre;
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (null == strs || strs.length == 0) {
            return "";
        }
        int count = strs.length;
        int length = strs[0].length();
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < count; j++) {
//                if () {
//
//                }
            }

        }
        return "";
    }

    public static void main(String[] args) {
        String[] str = {"flower", "flower", "flower"};
        String[] str1 = {"dog", "racecar", "car"};
        String[] str2 = {"a"};
        String[] str3 = {"", ""};
        System.out.println(longestCommonPrefix(str));
        System.out.println(longestCommonPrefix(str1));
        System.out.println(longestCommonPrefix(str2));
        System.out.println(longestCommonPrefix(str3));
        System.out.println("------------------------");
        System.out.println(practice(str));
        System.out.println(practice(str1));
        System.out.println(practice(str2));
        System.out.println(practice(str3));
    }

    public static String practice(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int length = Math.min(pre.length(), strs[i].length());
            int index = 0;
            while (index < length && pre.charAt(index) == strs[i].charAt(index)) {
                index++;
            }
            pre = pre.substring(0, index);
            if (pre.length() == 0) {
                break;
            }
        }
        return pre;
    }
}
