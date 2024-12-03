package com.labula.graph;

import java.util.*;

/**
 * course-schedule II
 *
 * @author zz
 */
public class No2Code210 {

    /**
     * 记录后序遍历结果
     */
    List<Integer> postOrder = new ArrayList<>();

    boolean[] visited;
    boolean[] onPath;

    boolean hasCycle = false;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //构建邻接表
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        //初始化
        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        //遍历
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        //有环，返回
        if (hasCycle) {
            return new int[]{};
        }

        //拓扑排序--（逆）后续遍历结果即为拓扑排序结果
        Collections.reverse(postOrder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postOrder.get(i);
        }
        return res;
    }

    private void traverse(List<Integer>[] graph, int i) {
        if (onPath[i]) {
            hasCycle = true;
        }

        if (visited[i] || hasCycle) {
            return;
        }

        onPath[i] = true;
        visited[i] = true;
        for (Integer integer : graph[i]) {
            traverse(graph, integer);
        }
        //添加后序遍历结果
        postOrder.add(i);
        onPath[i] = false;
    }

    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
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

    public static void main(String[] args) {
//        输出：[0,1]
        int numCourses = 4;
//        int[][] prerequisites = {{1, 0}};
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

//        System.out.println(Arrays.toString(new No2Code210().findOrder(numCourses, prerequisites)));
        System.out.println(Arrays.toString(new No2Code210().practice(numCourses, prerequisites)));
    }

    public int[] practice(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = build(numCourses, prerequisites);

        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            trave(graph, i);
        }

        if (hasCycle) {
            return new int[]{};
        }

        Collections.reverse(postOrder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postOrder.get(i);
        }

        return res;
    }

    private void trave(List<Integer>[] graph, int i) {
        if (onPath[i]) {
            hasCycle = true;
        }
        if (hasCycle || visited[i]) {
            return;
        }

        onPath[i] = true;
        visited[i] = true;

        for (Integer integer : graph[i]) {
            trave(graph, integer);
        }
        postOrder.add(i);
        onPath[i] = false;
    }

    private List<Integer>[] build(int numCourses, int[][] prerequisites) {
        LinkedList<Integer>[] graph = new LinkedList[numCourses];
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
