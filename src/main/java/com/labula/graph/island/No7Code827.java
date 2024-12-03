package com.labula.graph.island;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * make a large island
 *
 * @author zz
 */
public class No7Code827 {

    /**
     * 1、计算每个岛屿面积，放到map
     * 2、遍历海水区域，将海水变为陆地，计算此陆地四周联合的岛屿面积和
     *
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        //最终返回值(避免全是陆地的情况)
        int maxRes = 0;
        //code 标记岛屿编号，从2开始（0为还是，1为默认陆地），遍历完成后区域内应该为0，或>=2;
        int code = 2;
        //key:code;value:岛屿面积
        HashMap<Integer, Integer> map = new HashMap<>();

        //遍历岛屿面积
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfsArea(grid, i, j, code);
                    //记录最大面积的岛屿
                    maxRes = Math.max(maxRes, area);
                    map.put(code, area);
                    code++;
                }
            }
        }

        //遍历每块海水变为陆地后联合的岛屿面积和
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //合并岛屿
                int area = merge(grid, i, j, map);
                res = Math.max(res, area);
            }
        }
        //避免全是陆地的情况，对比合并后与单独计算面积的结果
        return Math.max(res, maxRes);
    }

    private int merge(int[][] grid, int i, int j, Map<Integer, Integer> map) {
        if (oufArea(grid, i, j)) {
            return 0;
        }
        //遍历的是海水区域，填海为陆
        if (grid[i][j] != 0) {
            return 0;
        }
        int res = 0;
        //遍历海变陆的地四周岛屿情况，将岛屿面积累加，set避免同一编号岛屿被重复计算
        HashSet<Integer> set = new HashSet<>();
        //陆地上方在区域内&&有编号,即有岛屿（此时除了海水0，其余都>=2），加入set
        if (!oufArea(grid, i - 1, j) && grid[i - 1][j] > 0) {
            set.add(grid[i - 1][j]);
        }
        if (!oufArea(grid, i, j - 1) && grid[i][j - 1] > 0) {
            set.add(grid[i][j - 1]);
        }
        if (!oufArea(grid, i + 1, j) && grid[i + 1][j] > 0) {
            set.add(grid[i + 1][j]);
        }
        if (!oufArea(grid, i, j + 1) && grid[i][j + 1] > 0) {
            set.add(grid[i][j + 1]);
        }
        for (Integer code : set) {
            res += map.get(code);
        }
        //将水变陆的面积加上
        res++;
        return res;
    }

    private int dfsArea(int[][] grid, int i, int j, int code) {
        if (oufArea(grid, i, j)) {
            return 0;
        }

        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = code;

        return 1 + dfsArea(grid, i + 1, j, code)
                + dfsArea(grid, i, j + 1, code)
                + dfsArea(grid, i - 1, j, code)
                + dfsArea(grid, i, j - 1, code);
    }

    private boolean oufArea(int[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1}, {1, 1}};
        System.out.println(new No7Code827().largestIsland(grid));
//        System.out.println(new No7Code827().practice(grid));
    }

    public int practice(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int key = 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, key);
                    map.put(key, area);
                    key++;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int area = merge1(grid, i, j, map);
                    res = Math.max(res, area);
                }
            }
        }
        return res;
    }

    private int merge1(int[][] grid, int i, int j, HashMap<Integer, Integer> map) {
        if (outOfArea(grid, i, j)) {
            return 0;
        }
        if (grid[i][j] != 0) {
            return 0;
        }

        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        if (!outOfArea(grid, i - 1, j) && grid[i - 1][j] > 0) {
            set.add(grid[i - 1][j]);
        }
        if (!outOfArea(grid, i, j - 1) && grid[i][j - 1] > 0) {
            set.add(grid[i][j - 1]);
        }
        if (!outOfArea(grid, i, j + 1) && grid[i][j + 1] > 0) {
            set.add(grid[i][j + 1]);
        }
        if (!outOfArea(grid, i + 1, j) && grid[i + 1][j] > 0) {
            set.add(grid[i + 1][j]);
        }
        for (Integer key : set) {
            res += map.get(key);
        }
        res++;
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int key) {
        if (outOfArea(grid, i, j)) {
            return 0;
        }
        if (grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = key;
        return 1 + dfs(grid, i + 1, j, key)
                + dfs(grid, i, j + 1, key)
                + dfs(grid, i - 1, j, key)
                + dfs(grid, i, j - 1, key);
    }

    private boolean outOfArea(int[][] grid, int i, int j) {
        return i < 0 || j < 0 || i >= grid.length || j >= grid[0].length;
    }


}
