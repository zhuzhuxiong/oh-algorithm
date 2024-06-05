package com.leetcode.classic150;

import java.util.Stack;

/**
 * @author zz
 */
public class No51Code20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else {
                if (!stack.isEmpty() && getChar(c) == stack.peek()) {
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char getChar(char c) {
        if ('}' == c) {
            return '{';
        }
        if (')' == c) {
            return '(';
        }
        return '[';
    }


    public static void main(String[] args) {
        String s = "()[]{}";
        No51Code20 code20 = new No51Code20();
        System.out.println(code20.isValid(s));
        System.out.println(code20.practice(s));

        String s1 = "(]}";
        System.out.println(code20.isValid(s1));
        System.out.println(code20.practice(s1));
    }

    public boolean practice(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ('{' == c || '(' == c || '[' == c) {
                stack.push(c);
            }else {
                if (!stack.isEmpty() && getChars(c) == stack.peek()){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private char getChars(char c){
        if (')' == c) {
            return '(';
        }
        if ('}' == c) {
            return '{';
        }
        return '[';
    }
}
