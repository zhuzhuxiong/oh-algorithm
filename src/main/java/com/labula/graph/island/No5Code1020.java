package com.labula.graph.island;

/**
 * number of enclaves
 *
 * @author zz
 */
public class No5Code1020 {

    /**
     * 与边界不相连的岛屿，淹没与边界相连的岛屿，统计剩余部分
     * @param grid
     * @return
     */
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            dfs(grid, 0, i);
            dfs(grid, m - 1, i);
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //统计的并非岛屿数量，而是相当于岛屿的面积
                if (grid[i][j] == 1) {
                    res++;
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
        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }


    public static void main(String[] args) {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
//        System.out.println(new No5Code1020().numEnclaves(grid));
        System.out.println(new No5Code1020().practice(grid));
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
                if (grid[i][j] == 1) {
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs1(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return;
        }

        if (grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;
        dfs1(grid, i + 1, j);
        dfs1(grid, i, j + 1);
        dfs1(grid, i - 1, j);
        dfs1(grid, i, j - 1);
    }
}
