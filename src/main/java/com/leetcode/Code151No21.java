package com.leetcode;

import java.util.ArrayDeque;

/**
 *
 * @author zz
 */
public class Code151No21 {

    public static String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == ' ') {
            left++;
        }
        while (left < right && s.charAt(right) == ' ') {
            right--;
        }

        ArrayDeque<String> deque = new ArrayDeque<>();
        StringBuilder sbWord = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (sbWord.length() != 0 && c == ' '){
                deque.offerFirst(sbWord.toString());
                sbWord.setLength(0);
            }else if (c != ' '){
                sbWord.append(c);
            }
            left++;
        }
        deque.offerFirst(sbWord.toString());
        return String.join(" ", deque);
    }

    public static void main(String[] args) {
        String s = "  hello world ";
        System.out.println(reverseWords(s));
        System.out.println(practice(s));
    }

    public static String practice(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right && s.charAt(left) == ' ') {
            left++;
        }
        while (left < right && s.charAt(right) == ' ') {
            right--;
        }

        ArrayDeque<String> deque = new ArrayDeque<>();
        StringBuilder sbWord = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);
            if (sbWord.length() != 0 && c == ' '){
                deque.offerFirst(sbWord.toString());
                sbWord.setLength(0);
            }else if (c != ' ') {
                sbWord.append(c);
            }
            left++;
        }
        deque.offerFirst(sbWord.toString());
        return String.join(" ",deque);
    }
}
