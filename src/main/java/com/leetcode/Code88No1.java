package com.leetcode;

import java.util.Arrays;

/**
 * 【数组】合并有序数组
 *
 * @author zz
 */
public class Code88No1 {

    /**
     * 尾指针
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        /** 判断可能的情况 */
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[tail] = nums2[p2--];
            } else if (p2 == -1) {
                nums1[tail] = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                nums1[tail] = nums1[p1--];
            } else {
                nums1[tail] = nums2[p2--];
            }
            tail--;
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int tail = m + n - 1;
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[tail] = nums1[m - 1];
                m--;
            } else {
                nums1[tail] = nums2[n - 1];
                n--;
            }
            tail--;
        }
        for (int i = 0; i < n; ++i) {
            nums1[i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] num2 = new int[]{2, 5, 6};
//        merge(num1,3,num2,3);
//        System.out.println(Arrays.toString(num1));
        practice(num1, 3, num2, 3);
        System.out.println(Arrays.toString(num1));
    }

    public static void practice(int[] nums1, int m, int[] nums2, int n) {

    }
}
