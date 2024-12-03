package com.labula.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * course schedule
 *
 * @author zz
 */
public class No1Code207 {

    /**
     * 顶点是否在路径上
     */
    boolean[] onPath;
    /**
     * 顶点是否已经被访问过
     */
    boolean[] visited;
    /**
     * 有向图是否成环
     */
    boolean hasCycle = false;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建有向图-临接表
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        //回溯
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        //无环 可以完成
        return !hasCycle;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        //临接表结构 [{},{}]
        LinkedList<Integer>[] graph = new LinkedList[numCourses];

        //初始化邻接表内层结构
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        //构建有向结构，先学会后面，才能学前面
        for (int[] edge : prerequisites) {
            int from = edge[1];
            int to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }

    private void traverse(List<Integer>[] graph, int i) {
        //顶点在有向路径上
        if (onPath[i]) {
            hasCycle = true;
        }

        //顶点已经被访问或者前面已经判断为环
        if (visited[i] || hasCycle) {
            return;
        }

        visited[i] = true;
        //回溯
        onPath[i] = true;
        for (Integer num : graph[i]) {
            traverse(graph, num);
        }
        onPath[i] = false;
    }

    public static void main(String[] args) {
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};
//        System.out.println(new No1Code207().canFinish(numCourses, prerequisites));
        System.out.println(new No1Code207().practice(numCourses, prerequisites));
    }

    public boolean practice(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = build(numCourses, prerequisites);

        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            trave(graph, i);
        }

        return !hasCycle;
    }

    private void trave(List<Integer>[] graph, int i) {
        if (onPath[i]) {
            hasCycle = true;
        }
        if (visited[i] || hasCycle) {
            return;
        }

        onPath[i] = true;
        visited[i] = true;
        for (Integer integer : graph[i]) {
            trave(graph, integer);
        }
        onPath[i] = false;
    }

    private List<Integer>[] build(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            graph[from].add(to);
        }
        return graph;
    }
}
