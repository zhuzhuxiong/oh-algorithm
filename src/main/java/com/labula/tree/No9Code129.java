package com.labula.tree;

import com.structure.tree.TreeNode;

/**
 * sum of root to leaf numbers
 * @author zz
 */
public class No9Code129 {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int tmp = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return tmp;
        }
        return dfs(root.left, tmp) + dfs(root.right, tmp);
    }

    public static void main(String[] args) {

    }

    public int practice(TreeNode root) {
        return dfs1(root, 0);
    }

    private int dfs1(TreeNode root, int i) {
        if (root == null) {
            return 0;
        }
        int tmp = i * 10 + root.val;
        if (root.left == null && root.right == null) {
            return tmp;
        }
        return dfs1(root.left, tmp) + dfs1(root.right, tmp);
    }
}
