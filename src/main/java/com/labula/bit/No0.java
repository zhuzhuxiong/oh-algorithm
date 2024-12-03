package com.labula.bit;

/**
 * bit base
 * @author zz
 */
public class No0 {

    public static void main(String[] args) {
        /**
         * 或|：遇1 则1
         * 与&：遇0 则0
         * 非~：按位取反
         * 异或^： 相异为1，相同为0；
         */
        // 1 (| + ' ') 字母变小写  A 0100 0001 ; ' '0010 0000
        System.out.println((char)('A' | ' '));
        //2 (& + _) 字母变大写 a 0110 0001; _ 0101 1111
        System.out.println((char)('b' & '_'));
        //3 (^ + ' ') 大小写互换
        System.out.println((char)('c' ^ ' '));
        System.out.println((char)('C' ^ ' '));

        //4 变量值互换
        int a = 1, b = 2;
//        a ^= b;
//        b ^= a;
//        a ^= b;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a:" + a + ";b:" + b);

        //5 加一 - 取反加一
        // n 0000 0001
        // ~n 1111 1110
        //- 对~n 取反加一 0000 0001 + 1 0000 0010
        int n = 1;
        n = -~n;
        System.out.println(n);
        //6 减一
        n = ~-n;
        System.out.println(n);

        //7 判断两个数是否异号 异：true，同：false
        int x = 1, y = -2;
        boolean bool = ((x ^ y) < 0);
        System.out.println(bool);

        //8 index & (arr.length - 1) 代替 取余 arr[index % arr.length]
        // & 能保证index变为负数时结果仍为正数，%会在index变为负数时结果也变为负数
        // 注意这个技巧只适用于数组长度是 2 的幂次方的情况
        int[] arr = {1,2,3,4};
        int index = 0;
        while (index < 100) {
            //
//            System.out.print(arr[index % arr.length]);
//            System.out.print(arr[index & arr.length - 1]);
            index++;
        }
        while (index > -100) {
            //
//            System.out.print(arr[index % arr.length]);
            System.out.print(arr[index & arr.length - 1]);
            index--;
        }

        // 9 n & (n - 1)
        //核心逻辑就是，n - 1 一定可以消除最后一个 1，同时把其后的 0 都变成 1，
        // 这样再和 n 做一次 & 运算，就可以仅仅把最后一个 1 变成 0 了。


    }
}
