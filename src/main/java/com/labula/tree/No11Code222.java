package com.labula.tree;

import com.structure.tree.TreeNode;

/**
 * count complete tree nodes
 * @author zz
 */
public class No11Code222 {

    public int countNodes(TreeNode root) {
        TreeNode left = root, right = root;
        int highLeft = 0, highRight = 0;

        while (left != null) {
            left = left.left;
            highLeft++;
        }
        while (right != null) {
            right = right.right;
            highRight++;
        }

        if (highLeft == highRight) {
            return (int) (Math.pow(2, highLeft) - 1);
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {

    }

    public int practice(TreeNode root) {
        return 1 + practice(root.left) + practice(root.right);
    }
}
