package com.labula.array;

/**
 * @author zz
 */
public class Code344N09 {

    public static void reverseString(char[] s) {
        int left = 0,right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {

    }
}
