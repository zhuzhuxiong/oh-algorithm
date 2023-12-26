package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 【数组】返回长度n的数组nums中的多数元素；多数元素：数组中占比大于n/2;
 *
 * @author zz
 */
public class Code169 {

    /**
     * 元素统计 利用hash
     */
    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (!countMap.containsKey(num)) {
                countMap.put(num, 1);
            } else {
                countMap.put(num, countMap.get(num) + 1);
            }
        }

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    public static int divide(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3};
        System.out.println(majorityElement(nums));

        int[] nums1 = new int[]{3, 2, 3};
        System.out.println(practice(nums1));
    }

    public static int practice(int[] nums) {
        return 0;
    }
}
