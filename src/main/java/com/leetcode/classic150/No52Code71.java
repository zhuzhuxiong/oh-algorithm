package com.leetcode.classic150;

import java.util.Stack;

/**
 * 简化路径
 * @author zz
 */
public class No52Code71 {

    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String str : strs) {
            if (str.isEmpty() || ".".equals(str)){
                continue;
            }
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(str);
        }
        String res = "";
        while (!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }

        return res.isEmpty() ? "/" : res;
    }


    public static void main(String[] args) {
        String s = "/a/./b/../../c/";
        No52Code71 code71 = new No52Code71();
        System.out.println(code71.simplifyPath(s));
        System.out.println(code71.practice(s));
    }

    public String practice(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for (String str : strs) {
            if (str.isEmpty() || ".".equals(str)) {
                continue;
            }
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(str);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}
