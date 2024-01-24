package com.leetcode;

/**
 * @author
 */
public class Code135No15 {

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }

        int right = 0, sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            sum = sum + Math.max(left[i], right);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] r1 = {1, 0, 2};
        int[] r2 = {1, 2, 2};
        System.out.println(candy(r1));
        System.out.println(candy(r2));
    }
}
