package com.labula.tree;

import com.structure.tree.TreeNode;

import java.util.ArrayList;

/**
 * @author zz
 */
public class No8Code116 {

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    private void traverse(Node n1, Node n2) {
        if (n1 == null || n2 == null) {
            return;
        }
        n1.next = n2;

        traverse(n1.left, n1.right);
        traverse(n2.left, n2.right);
        traverse(n1.right, n2.left);

    }

    public static void main(String[] args) {

    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
