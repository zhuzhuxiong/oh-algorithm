package com.labula.array.binary;

/**
 * 在D天内送达包裹的能力
 *
 * @author zz
 */
public class No5Code1011 {

    public int shipWithinDays(int[] weights, int days) {
        //左右范围定义如 410 题
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(left, weight);
            right += weight;
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int n = fun(weights, mid);
            if (n == days) {
                right = mid - 1;
            } else if (n < days) {
                right = mid - 1;
            } else if (n > days) {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 逻辑转换：求运载能力--> 根据给出的能力 求 天数
     * 单调：能力X 越大，返回值days越小
     * @param weights
     * @param x 能力
     * @return
     */
    private int fun(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) {
                    break;
                } else {
                    cap = cap - weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }

    public static void main(String[] args) {
//        输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//        输出：15
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        No5Code1011 code1011 = new No5Code1011();
        System.out.println(code1011.shipWithinDays(weights, 5));
        System.out.println(code1011.practice(weights, 5));
    }

    public int practice(int[] weights, int days) {
        int left = 0, right = 0;
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int n = func(weights, mid);
            if (n == days) {
                right = mid - 1;
            }else if (n > days) {
                left = mid + 1;
            }else if (n < days) {
                right = mid - 1;

            }
        }
        return left;
    }

    private int func(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            int cap = x;
            while (i < weights.length) {
                if (weights[i] > cap) {
                    break;
                }else {
                    cap -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }


}
