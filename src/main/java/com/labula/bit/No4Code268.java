package com.labula.bit;

/**
 * missing number
 * @author zz
 */
public class No4Code268 {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int res = 0;

        for (int i = 0; i < length; i++) {
            res = res ^ i ^ nums[i];
        }
        res = res ^ length;
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(new No4Code268().missingNumber(nums));
        System.out.println(new No4Code268().practice(nums));
    }

    public int practice(int[] nums) {
        int res = 0;
        res ^= nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i] ^ i;
        }
        return res;
    }
}
