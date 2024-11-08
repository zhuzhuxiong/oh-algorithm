package com.labula.array.binary;

/**
 * 香蕉 珂珂
 *
 * @author zz
 */
public class No6Code875 {

    /**
     * 根据时间 求速度 --> 根据速度 求时间
     *
     * @param piles
     * @param h     总耗时
     * @return
     */
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1000000000;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int res = func(piles, mid);

            if (res == h) {
                right = mid - 1;
            } else if (res < h) {
                right = mid - 1;
            } else if (res > h) {
                left = mid + 1;
            }
        }
        return left;
    }

    private int func(int[] piles, int v) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours = hours + (piles[i] / v);
            //小于珂珂速度时，也占用一个小时
            if (piles[i] % v > 0) {
                hours++;
            }
        }
        return hours;
    }

    public static void main(String[] args) {
//        输入：piles = [3,6,7,11], h = 8
//        输出：4
        int[] piles = {3, 6, 7, 11};
        int[] piles1 = {805306368,805306368,805306368};
        No6Code875 code875 = new No6Code875();
        System.out.println(code875.minEatingSpeed(piles, 8));
        System.out.println(code875.minEatingSpeed(piles1, 1000000000));
        System.out.println(code875.practice(piles, 8));
        System.out.println(code875.practice(piles1, 1000000000));
    }

    public int practice(int[] piles, int h) {
        int left = 1, right = 1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int n = fun(piles, mid);
            if (n == h) {
                right = mid;
            }else if (n > h) {
                left = mid + 1;
            }else if (n < h) {
                right = mid;
            }
        }
        return left;
    }

    private int fun(int[] piles, int v) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += piles[i] / v;
            if (piles[i] % v > 0) {
                hours++;
            }
        }
        return hours;
    }
}
