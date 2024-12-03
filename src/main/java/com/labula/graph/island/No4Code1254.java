package com.labula.graph.island;

import com.util.PrintUtil;

/**
 * number of close islands
 * @author zz
 */
public class No4Code1254 {

    /**
     * 思路：沉没与边界相连岛屿，《统计岛屿数量》即封闭岛屿数量
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //淹没与边界相连的岛屿，剩下的是封闭岛屿
        for (int j = 0; j < n; j++) {
            //上
            dfs(grid, 0, j);
            //xia
            dfs(grid, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            //左
            dfs(grid, i, 0);
            //右
            dfs(grid, i, n - 1);
        }

        //200 统计岛屿数量
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }
        //岛屿淹没法，此题0为陆地，1为海水
        grid[i][j] = 1;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
//        System.out.println(new No4Code1254().closedIsland(grid));
        System.out.println(new No4Code1254().practice(grid));
        PrintUtil.printMatrix1(grid);
    }

    public int practice(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            dfs1(grid, i, 0);
            dfs1(grid, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs1(grid, 0, j);
            dfs1(grid, m - 1, j);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    res++;
                    dfs1(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs1(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == 1) {
            return;
        }

        grid[i][j] = 1;
        dfs1(grid, i + 1, j);
        dfs1(grid, i, j + 1);
        dfs1(grid, i - 1, j);
        dfs1(grid, i, j - 1);
    }


}
