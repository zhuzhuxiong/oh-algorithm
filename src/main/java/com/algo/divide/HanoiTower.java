package com.algo.divide;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 汉诺塔问题
 * @author zz
 */
public class HanoiTower {

    public static void solve(List<Integer> A, List<Integer> B, List<Integer> C) {
        dfs(A.size() , A, B ,C);
    }

    private static void dfs(int i, List<Integer> src, List<Integer> buf, List<Integer> tar) {
        if (i == 1) {
            move(src, tar);
            return;
        }
        dfs(i-1,src,tar,buf);
        move(src,tar);
        dfs(i-1,buf,src,tar);
    }

    private static void move(List<Integer> src, List<Integer> tar) {
        /** src : {3,2,1} 取顶要去数组末尾 */
        Integer tower = src.remove(src.size() - 1);
        tar.add(tower);
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(3, 2, 1));
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();


        System.out.println("异动前A：" + A);
        System.out.println("异动前B：" + B);
        System.out.println("异动前C：" + C);

        solve(A,B,C);

        System.out.println("异动后A：" + A);
        System.out.println("异动后B：" + B);
        System.out.println("异动后C：" + C);
    }
}
