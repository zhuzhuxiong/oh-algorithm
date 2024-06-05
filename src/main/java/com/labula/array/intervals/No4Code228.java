package com.labula.array.intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * 汇总
 * @author zz
 */
public class No4Code228 {

    public List<String> summaryRanges(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int low = i;
            i++;
            while (i < nums.length && nums[i] == nums[i-1] + 1){
                i++;
            }
            int high = i - 1;
            StringBuilder sb = new StringBuilder(String.valueOf(nums[low]));
            if (low < high) {
                sb.append("->");
                sb.append(nums[high]);
            }
            res.add(sb.toString());
        }
        return res;
    }


    public static void main(String[] args) {
        //输出：["0->2","4->5","7"]
        int[] nums = {0,1,2,4,5,7};
        No4Code228 code228 = new No4Code228();
        System.out.println(code228.summaryRanges(nums));
        System.out.println(code228.practice(nums));
    }

    public List<String> practice(int[] nums) {
        ArrayList<String> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int low = i;
            i++;
            while (i < nums.length && nums[i] == nums[i-1] +1) {
                i++;
            }
            int high = i -1;
            StringBuilder sb = new StringBuilder(String.valueOf(nums[low]));
            if (low < high) {
                sb.append("->");
                sb.append(nums[high]);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
