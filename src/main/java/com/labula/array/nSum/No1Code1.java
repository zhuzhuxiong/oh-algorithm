package com.labula.array.nSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 两数之和
 * @author zz
 */
public class No1Code1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target-nums[i]),i};
            }else {
                map.put(nums[i],i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        No1Code1 code1 = new No1Code1();
        System.out.println(Arrays.toString(code1.twoSum(nums, 9)));
    }

}
