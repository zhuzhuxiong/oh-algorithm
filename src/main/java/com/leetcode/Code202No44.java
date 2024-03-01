package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author
 */
public class Code202No44 {

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (1 != n && !set.contains(n)) {
            set.add(n);
            int total = 0;
            while (n > 0) {
                int d = n%10;
                n = n/10;
                total += d*d;
            }
            n = total;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
        System.out.println(practice(2));
    }

    public static boolean practice(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            int total = 0;
            while (n > 0) {
                int d = n % 10;
                total += d * d;
                n = n / 10;
            }
            n = total;
        }
        return n == 1;
    }
}
