package com.labula.tree;

import com.structure.tree.TreeNode;

/**
 * binary tree maximum path sum
 * @author zz
 */
public class No10Code124 {

    int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        ans = Math.max(left + right + root.val, ans);
        return Math.max(Math.max(left, right) + root.val, 0);
    }

    public static void main(String[] args) {

    }
}
