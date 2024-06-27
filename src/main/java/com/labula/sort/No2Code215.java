package com.labula.sort;

import java.util.PriorityQueue;
import java.util.Random;

/**
 * @author zz
 */
public class No2Code215 {

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }

    /**
     * 快速选择算法
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int low = 0, high = nums.length - 1;
        k = nums.length - k;
        while (low <= high) {
            int p = partition(nums, low, high);
            if (p > k) {
                high = p - 1;
            }else if (p < k) {
                low = p + 1;
            }else {
                return nums[p];
            }
        }
        return -1;
    }

    private int partition(int[] nums, int low, int high) {
        int p = nums[low];
        int i = low + 1, j = high;
        while (i <= j) {
            while (i < high && nums[i] <= p) {
                i++;
            }
            while (i > low && nums[j] > p) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }

    private void shuffle(int[] nums) {
        Random random = new Random();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int k = i + random.nextInt(length - i);
            swap(nums, i, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        No2Code215 code215 = new No2Code215();
        System.out.println(code215.findKthLargest(nums, 2));
        System.out.println(code215.findKthLargest1(nums, 2));
        System.out.println(code215.findKthLargest2(nums, 2));
    }

    public int findKthLargest2(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        k = nums.length - k;
        while (lo <= hi) {
            int p = partition1(nums, lo, hi);
            if (p > k) {
                hi = p - 1;
            }else if (p < k) {
                lo = p + 1;
            }else {
                return nums[p];
            }
        }
        return -1;
    }
    private int partition1(int[] nums, int lo, int hi) {
        int p = nums[lo];
        int i = lo + 1, j = hi;
        while (i <= j) {
            while (i < hi && nums[i] <= p) {
                i++;
            }
            while (j > lo && nums[j] > p) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }
}
