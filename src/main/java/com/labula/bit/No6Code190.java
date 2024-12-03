package com.labula.bit;

/**
 * @author
 */
public class No6Code190 {

    public int reverseBits(int n) {
        int res = 0;
        // 循环处理32位，idx为位索引
        for (int idx = 0; idx < 32; idx++) {
            // 获取当前最低位
            int digit = n & 1;
            // 将最低位右移掉
            n >>= 1;
            // | 合并结果 将这个最低位反转到它实际位置上去
            res |= (digit << (31 - idx));
        }
        return res;
    }

    public static void main(String[] args) {
//        输出：964176192 (00111001011110000010100101000000)
        int n = 0000001010010100;
        System.out.println(new No6Code190().reverseBits(n));
    }

    public int practice(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int low = n & 1;
            n >>= 1;
            res |= (low << (31 - i));
        }
        return res;
    }
}
