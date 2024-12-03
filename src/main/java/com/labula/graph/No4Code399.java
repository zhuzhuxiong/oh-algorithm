package com.labula.graph;


import java.util.*;
import java.util.stream.Collectors;

/**
 * evaluate division
 *
 * @author zz
 */
public class No4Code399 {

    /**
     * BFS 双向有权图
     *
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // a与b的商，即为a->b的权重，求的结果为 连接两个节点的边的权重的乘积
        //将 equations 构建邻接表，key:顶点a,value:a到Edge中节点的权重，a:b的weight；
        HashMap<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            //顶点
            String a = equation.get(0), b = equation.get(1);
            //权重
            double w = values[i];

            //构建a->b
            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            graph.get(a).add(new Edge(b, w));

            //构建b->a
            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(b).add(new Edge(a, 1.0 / w));
        }

        //返回的结果
        double[] res = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            //每一组之内
            List<String> query = queries.get(i);
            String start = query.get(0), end = query.get(1);
            //计算结果
            res[i] = bfs(graph, start, end);
        }
        return res;
    }

    private double bfs(HashMap<String, List<Edge>> graph, String start, String end) {
        //不包含起、终点
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        //起、终点相同
        if (start.equals(end)) {
            return 1.0;
        }

        //bfs 框架
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        //key:顶点，value:从start到该顶点的权重（路径乘积）
        HashMap<String, Double> weight = new HashMap<>();
        weight.put(start, 1.0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (Edge edge : graph.get(cur)) {
                if (visited.contains(edge.node)) {
                    continue;
                }
                //更新节点 以及 乘积
                weight.put(edge.node, weight.get(cur) * edge.weight);
                if (edge.node.equals(end)) {
                    return weight.get(end);
                }

                visited.add(edge.node);
                queue.offer(edge.node);
            }
        }
        return -1.0;
    }

    class Edge {
        String node;
        Double weight;

        public Edge(String node, Double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
//        输出：[6.00000,0.50000,-1.00000,1.00000,-1.00000]

        List<List<String>> equations = Arrays.stream(new String[][]{{"a", "b"}, {"b", "c"}}).map(Arrays::asList).collect(Collectors.toList());
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.stream(new String[][]{{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}}).map(Arrays::asList).collect(Collectors.toList());
        System.out.println(Arrays.toString(new No4Code399().calcEquation(equations, values, queries)));
        System.out.println(Arrays.toString(new No4Code399().practice(equations, values, queries)));
    }


    public double[] practice(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Edge>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0), b = equation.get(1);
            double w = values[i];

            if (!graph.containsKey(a)) {
                graph.put(a, new ArrayList<>());
            }
            graph.get(a).add(new Edge(b, w));

            if (!graph.containsKey(b)) {
                graph.put(b, new ArrayList<>());
            }
            graph.get(b).add(new Edge(a,1.0/w));
        }

        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0), end = query.get(1);
            res[i] = bfs1(graph, start,end);
        }
        return res;
    }

    private double bfs1(HashMap<String, List<Edge>> graph, String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) {
            return -1.0;
        }
        if (start.equals(end)) {
            return 1.0;
        }

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        HashMap<String, Double> weight = new HashMap<>();
        weight.put(start, 1.0);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            for (Edge edge : graph.get(cur)) {
                if (visited.contains(edge.node)) {
                    continue;
                }
                weight.put(edge.node, edge.weight * weight.get(cur));
                if (edge.node.equals(end)) {
                    return weight.get(edge.node);
                }

                visited.add(edge.node);
                queue.offer(edge.node);
            }
        }

        return -1.0;
    }
}
