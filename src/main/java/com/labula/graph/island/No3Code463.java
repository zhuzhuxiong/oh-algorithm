package com.labula.graph.island;

/**
 * 岛屿周长
 *
 * @author zz
 */
public class No3Code463 {

    public int islandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j, m, n);
                }
            }
        }
        return 0;
    }

    /**
     * 周长 = 岛屿与图边界重合（黄色） + 岛屿与海水交界（蓝色）
     * @param grid
     * @param i
     * @param j
     * @param m
     * @param n
     * @return
     */
    private int dfs(int[][] grid, int i, int j, int m, int n) {
        //与矩阵边界重合部分 --对应矩阵边缘 1
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 1;
        }
        // 与海水交界部分
        if (grid[i][j] == 0) {
            return 1;
        }
        // 过滤重复统计
        if (grid[i][j] != 1) {
            return 0;
        }

        //标记已统计部分
        grid[i][j] = 2;

        return dfs(grid, i + 1, j, m, n)
                + dfs(grid, i, j + 1, m, n)
                + dfs(grid, i - 1, j, m, n)
                + dfs(grid, i, j - 1, m, n)
                ;
    }

    public static void main(String[] args) {
//        输出：16
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        No3Code463 code463 = new No3Code463();
//        System.out.println(code463.islandPerimeter(grid));
        System.out.println(code463.practice(grid));
    }

    public int practice(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j);
                }
            }
        }
        return 0;
    }

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 1;
        }
        if (grid[i][j] == 0) {
            return 1;
        }
        if (grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = 2;
        return dfs(grid, i + 1, j)
                + dfs(grid, i, j + 1)
                + dfs(grid, i - 1, j)
                + dfs(grid, i, j - 1);
    }


}
