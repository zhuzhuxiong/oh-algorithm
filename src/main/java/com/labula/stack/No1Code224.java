package com.labula.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 计算器
 *
 * @author zz
 */
public class No1Code224 {

    public int calculate(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }
        return helper(queue);
    }

    private int helper(Queue<Character> queue) {
        LinkedList<Integer> res = new LinkedList<>();
        int num = 0;
        char sign = '+';

        while (!queue.isEmpty()) {
            Character c = queue.poll();
            if (Character.isDigit(c)) {
                num = 10 * num + Character.getNumericValue(c);
            }

            if (c == '(') {
               num = helper(queue);
            }

            if ((!Character.isDigit(c) && c != ' ') || queue.isEmpty()) {
                if (sign == '+') {
                    res.push(num);
                } else if (sign == '-') {
                    res.push(-num);
                } else if (sign == '*') {
                    res.push(res.pop() * num);
                } else if (sign == '/') {
                    res.push(res.pop() / num);
                }
                num = 0;
                sign = c;
            }

            if (c == ')') {
                break;
            }

        }

        int result = 0;
        for (Integer re : res) {
            result += re;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        String s1 = "1 + 1";
        No1Code224 code224 = new No1Code224();
        System.out.println(code224.calculate(s));
        System.out.println(code224.calculate(s1));
        System.out.println(code224.practice(s));
    }

    public int practice(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.add(c);
        }
        return helper1(queue);
    }

    private int helper1(Queue<Character> queue){
        int num = 0;
        char sign = '+';
        LinkedList<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            if (Character.isDigit(c)) {
                num = 10 * num + Character.getNumericValue(c);
            }

            if (c == '(') {
                num = helper1(queue);
            }

            if ((!Character.isDigit(c) && c != ' ') || queue.isEmpty()) {
                if (sign == '+') {
                    res.push(num);
                }else if (sign == '-') {
                    res.push(-num);
                }else if (sign == '*'){
                    res.push(res.pop() * num);
                }else if (sign == '/') {
                    res.push(res.pop() / num);
                }
                num = 0;
                sign = c;
            }

            if (c == ')') {
                break;
            }
        }

        int count = 0;
        for (Integer re : res) {
            count += re;
        }
        return count;
    }
}
