package com.labula.array.binary;

/**
 * 分割数组最大值
 * 将nums，分成k组，被分割后的新数组和的最大值 最小
 * @author zz
 */
public class No4Code410 {

    public int splitArray(int[] nums, int k) {
        //getMax：nums中单个元素的最大值，getSum：nums所有元素和
        int lo = getMax(nums), hi = getSum(nums);
        /** 基础思路--转换为二分 */
//        for (int max = lo; max < hi; max++) {
//            int n = split(nums, max);
//
//            if (n <= k) {
//                return max;
//            }
//        }
        //返回最小值，最左边界
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int n = split(nums, mid);
            if (k < n) {
                lo = mid + 1;
            }else if (k > n) {
                hi = mid - 1;
            }else if (k == n) {
                //最左边界
                hi = mid - 1;
            }
        }
        return lo;
    }

    /**
     * 辅助方法：问题转化，限制子数组和最大为max，返回nums 至少被分割成几个子数组。
     * @param nums
     * @param max
     * @return
     */
    private int split(int[] nums, int max) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > max) {
                count++;
                sum = nums[i];
            }else {
                sum += nums[i];
            }
        }
        return count;
    }

    private int getSum(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res += num;
        }
        return res;
    }

    private int getMax(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = Math.max(num, res);
        }
        return res;
    }




    public static void main(String[] args) {
//        输入：nums = [7,2,5,10,8], k = 2
//        输出：18
//        解释：一共有四种方法将 nums 分割为 2 个子数组。
//        其中最好的方式是将其分为 [7,2,5] 和 [10,8] 。因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
        int[] nums = {7,2,5,10,8};
        No4Code410 code410 = new No4Code410();
        System.out.println(code410.splitArray(nums, 2));
        System.out.println(code410.practice(nums, 2));
    }

    public int practice(int[] nums, int k) {
        int lo = getMax(nums), hi = getSum(nums);
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int n = split1(nums, mid);
            if (n == k) {
                hi = mid - 1;
            }else if (n > k) {
                lo = mid + 1;
            }else if (n < k) {
                hi = mid - 1;
            }
        }
        return lo;
    }

    private int split1(int[] nums, int max) {
        int count = 1;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (res + nums[i] > max) {
                count++;
                res = nums[i];
            }else {
                res += nums[i];
            }
        }
        return count;
    }
}
