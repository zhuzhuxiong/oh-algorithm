package com.leetcode.classic150;

/**
 * 罗马数字 转 整数
 * @author zz
 */
public class No17Code13 {

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && swag(chars[i]) < swag(chars[i+1])) {
                sum = sum - swag(chars[i]);
            }else {
                sum = sum + swag(chars[i]);
            }
        }
        return sum;
    }

    private static int swag(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
        }
        return 0;
    }

    static int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num = num - values[i];
                res.append(symbols[i]);
            }
            if (num == 0){
                break;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));

        System.out.println(intToRoman(3));
    }


}
