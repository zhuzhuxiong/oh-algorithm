package com.leetcode;

/**
 * @author
 */
public class Code125No25 {

    public static boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        int left = 0, right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
