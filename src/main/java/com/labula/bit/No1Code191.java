package com.labula.bit;

/**
 * number of 1 bits
 * @author zz
 */
public class No1Code191 {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No1Code191().hammingWeight(11));
        System.out.println(new No1Code191().practice(11));
        System.out.println(Integer.toBinaryString(3));
    }

    public int practice(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }
}
