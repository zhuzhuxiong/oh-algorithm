package com.labula.bit;

/**
 * single number a ^ a = 0; a ^ 0 = a;
 *
 * @author zz
 */
public class No3Code136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
//        输出：4
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(new No3Code136().singleNumber(nums));
        System.out.println(new No3Code136().practice(nums));
    }

    public int practice(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
