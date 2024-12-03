package com.labula.graph.island;

/**
 * sub - islands
 *
 * @author zz
 */
public class No6Code1905 {

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs(grid2, i, j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid2, int i, int j) {
        int m = grid2.length, n = grid2[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid2[i][j] == 0) {
            return;
        }
        grid2[i][j] = 0;
        dfs(grid2, i + 1, j);
        dfs(grid2, i, j + 1);
        dfs(grid2, i - 1, j);
        dfs(grid2, i, j - 1);
    }

    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
//        System.out.println(new No6Code1905().countSubIslands(grid1, grid2));
        System.out.println(new No6Code1905().practice(grid1, grid2));
    }

    public int practice(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfs1(grid2, i, j);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    dfs1(grid2, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs1(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j>= grid[0].length) {
            return;
        }
        if (grid[i][j] != 1) {
            return;
        }
        grid[i][j] = 0;

        dfs1(grid, i + 1, j);
        dfs1(grid, i, j + 1);
        dfs1(grid, i - 1, j);
        dfs1(grid, i, j - 1);
    }


}
