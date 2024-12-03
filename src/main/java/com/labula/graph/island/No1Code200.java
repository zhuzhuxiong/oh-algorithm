package com.labula.graph.island;

/**
 * 图-岛屿数量
 *
 * @author zz
 */
public class No1Code200 {

    /**
     * DFS
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //遇到陆地开始统计
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        //base case
        //划定边界（超过范围直接返回）
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        //标记遍历过的点（0：海，1：未遍历陆地，2：已遍历陆地）
        if (grid[i][j] != '1') {
            return;
        }
        //标记遍历过的陆地，可以设置为'0',即陆地沉没法；
        grid[i][j] = '2';
        //向四方搜索 -- 右 下 左 上
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
//        输出：1
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

//        System.out.println(new No1Code200().numIslands(grid));
        System.out.println(new No1Code200().practice(grid));
    }

    public int practice(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs1(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs1(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs1(grid, i + 1, j);
        dfs1(grid, i, j + 1);
        dfs1(grid, i - 1, j);
        dfs1(grid, i, j - 1);
    }
}
