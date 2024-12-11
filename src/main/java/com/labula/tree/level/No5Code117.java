package com.labula.tree.level;

import com.structure.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * populating next right pointers in each node II
 * @author zz
 */
public class No5Code117 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node pre = null;

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();


                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;


                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            System.out.println(i);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        Node() {
        }

        public Node(int value) {
            this.val = value;
        }

        Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }
}
