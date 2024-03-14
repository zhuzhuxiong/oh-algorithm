package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 区间
 * @author zz
 */
public class Code228No47 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int i = 0, n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i - 1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer buffer = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                buffer.append("->");
                buffer.append(nums[high]);
            }
            list.add(buffer.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4,5,7};
        System.out.println(summaryRanges(nums));
        System.out.println(practice(nums));
    }

    public static List<String> practice(int[] nums) {
        ArrayList<String> list = new ArrayList<>();
        int i = 0, n = nums.length;
        while (i < n) {
            int low = i;
            i++;
            while (i < n && nums[i] == nums[i-1] + 1) {
                i++;
            }
            int high = i - 1;
            StringBuffer buffer = new StringBuffer(Integer.toString(nums[low]));
            if (low < high) {
                buffer.append("->");
                buffer.append(nums[high]);
            }
            list.add(buffer.toString());
        }
        return list;
    }
}
