package com.leetcode.classic150;

import java.util.Stack;

/**
 * @author
 */
public class No54Code150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ((!"+".equals(token)) && (!"-".equals(token)) && (!"*".equals(token)) && (!"/".equals(token))) {
                stack.push(Integer.parseInt(token));
            }else {
                Integer s2 = stack.pop();
                Integer s1 = stack.pop();

                if (("+".equals(token))) {
                    stack.push(s1 + s2);
                }
                if (("-".equals(token))) {
                    stack.push(s1 - s2);
                }
                if (("*".equals(token))) {
                    stack.push(s1 * s2);
                }
                if (("/".equals(token))) {
                    stack.push(s1 / s2);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
        String[] token1 = {"4","13","5","/","+"};
        String[] token2 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        String[] token3 = {"18"};
        No54Code150 code150 = new No54Code150();
        System.out.println(code150.evalRPN(tokens));
        System.out.println(code150.evalRPN(token1));
        System.out.println(code150.evalRPN(token2));
        System.out.println(code150.evalRPN(token3));
    }
}
