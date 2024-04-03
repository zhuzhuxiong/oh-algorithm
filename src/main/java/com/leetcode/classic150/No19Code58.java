package com.leetcode.classic150;

import java.util.Arrays;

/**
 * 最后一个单词长度
 * @author zz
 */
public class No19Code58 {

    public static int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        return split[split.length - 1].length();
    }

    public static int lengthOfLastWord1(String s) {
        int index = s.length() - 1;

        while (s.charAt(index) == ' ') {
            index--;
        }
        int sum = 0;
        while (index >= 0 && s.charAt(index) != ' '){
            index--;
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        String[] split = s.split(" ");
        System.out.println(Arrays.toString(split));

        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWord1(s));
    }
}
