package com.labula.dp;

/**
 * 最小编辑距离 扩展
 * @author zz
 */
public class No6Code72_1 {

    class Node{
        int val;
        int choice;
        // 0 代表啥都不做
        // 1 代表插入
        // 2 代表删除
        // 3 代表替换
        public Node(int val, int choice){
            this.val = val;
            this.choice = choice;
        }
    }

    /**
     * todo 输出编辑操作版本 copy
     * @param s1
     * @param s2
     * @return
     */
    int minDistance2(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        Node[][] dp = new Node[m + 1][n + 1];
        // base case
        for (int i = 0; i <= m; i++) {
            // s1 转化成 s2 只需要删除一个字符
            dp[i][0] = new Node(i, 2);
        }
        for (int j = 1; j <= n; j++) {
            // s1 转化成 s2 只需要插入一个字符
            dp[0][j] = new Node(j, 1);
        }
        // 状态转移方程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    // 如果两个字符相同，则什么都不需要做
                    Node node = dp[i - 1][j - 1];
                    dp[i][j] = new Node(node.val, 0);
                } else {
                    // 否则，记录代价最小的操作
                    dp[i][j] = minNode(
                            dp[i - 1][j],
                            dp[i][j - 1],
                            dp[i-1][j-1]
                    );
                    // 并且将编辑距离加一
                    dp[i][j].val++;
                }
            }
        }
        // 根据 dp table 反推具体操作过程并打印
        printResult(dp, s1, s2);
        return dp[m][n].val;
    }

    // 计算 delete, insert, replace 中代价最小的操作
    Node minNode(Node a, Node b, Node c) {
        Node res = new Node(a.val, 2);

        if (res.val > b.val) {
            res.val = b.val;
            res.choice = 1;
        }
        if (res.val > c.val) {
            res.val = c.val;
            res.choice = 3;
        }
        return res;
    }

    void printResult(Node[][] dp, String s1, String s2) {
        int rows = dp.length;
        int cols = dp[0].length;
        int i = rows - 1, j = cols - 1;
        System.out.println("Change s1=" + s1 + " to s2=" + s2 + ":\n");
        while (i != 0 && j != 0) {
            char c1 = s1.charAt(i - 1);
            char c2 = s2.charAt(j - 1);
            int choice = dp[i][j].choice;
            System.out.print("s1[" + (i - 1) + "]:");
            switch (choice) {
                case 0:
                    // 跳过，则两个指针同时前进
                    System.out.println("skip '" + c1 + "'");
                    i--; j--;
                    break;
                case 1:
                    // 将 s2[j] 插入 s1[i]，则 s2 指针前进
                    System.out.println("insert '" + c2 + "'");
                    j--;
                    break;
                case 2:
                    // 将 s1[i] 删除，则 s1 指针前进
                    System.out.println("delete '" + c1 + "'");
                    i--;
                    break;
                case 3:
                    // 将 s1[i] 替换成 s2[j]，则两个指针同时前进
                    System.out.println(
                            "replace '" + c1 + "'" + " with '" + c2 + "'");
                    i--; j--;
                    break;
            }
        }
        // 如果 s1 还没有走完，则剩下的都是需要删除的
        while (i > 0) {
            System.out.print("s1[" + (i - 1) + "]:");
            System.out.println("delete '" + s1.charAt(i - 1) + "'");
            i--;
        }
        // 如果 s2 还没有走完，则剩下的都是需要插入 s1 的
        while (j > 0) {
            System.out.print("s1[0]:");
            System.out.println("insert '" + s2.charAt(j - 1) + "'");
            j--;
        }
    }

    public static void main(String[] args) {

    }
}
