package com.leetcode;

/**
 * 【数组】H 指数
 *
 * @author zz
 */
public class Code274No11 {

    public static int hIndex(int[] citations) {
        int left = 0, right = citations.length;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            int count = 0;
            for (int citation : citations) {
                if (citation >= mid) {
                    count++;
                }
            }
            if (count >= mid) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int[] citations1 = {1, 3, 1};
        System.out.println(hIndex(citations));
        System.out.println(hIndex(citations1));
    }


}
