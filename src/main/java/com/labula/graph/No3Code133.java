package com.labula.graph;

import java.util.*;

/**
 * clone graph
 *
 * @author zz
 */
public class No3Code133 {

    /**
     * DFS
     *
     * @param node
     * @return
     */
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor));
        }
        return clone;
    }


    /**
     * BFS
     *
     * @param node
     * @return
     */
    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        Node clone = new Node(node.val, new ArrayList<>());

        map.put(node, clone);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return clone;
    }

    public static void main(String[] args) {

    }

    public Node practiceDFS(Node node) {
        return dfs1(node);
    }

    private Node dfs1(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        map.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs1(neighbor));
        }
        return clone;
    }

    public Node practiceBFS(Node node) {
        if (node == null) {
            return null;
        }
        Node clone = new Node(node.val);
        HashMap<Node, Node> map = new HashMap<>();
        map.put(node, clone);

        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    map.put(neighbor, new Node(neighbor.val));
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }
        return clone;
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
