package com.leetcode;

/**
 * @author
 */
public class Code134No14 {

    /**
     * 总gas > 总cost 即可完成；
     * cur < 0 即以i为起点，完成不了，inx+1 继续循环
     * @return
     */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int total = 0;
        int idx = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];
            if (cur < 0) {
                idx = (i + 1) % gas.length;
                cur = 0;
            }
        }
        if (total < 0) {
            return -1;
        }
        return idx;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuit(gas, cost));
    }

    public static int practice(int[] gas, int[] cost) {
        int idx = 0;

        return idx;
    }
}
