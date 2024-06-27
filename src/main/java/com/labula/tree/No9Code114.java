package com.labula.tree;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.Arrays;

/**
 * @author zz
 */
public class No9Code114 {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.listToTree(Arrays.asList(1, 2, 5, 3, 4, null, 6));
        No9Code114 code114 = new No9Code114();
        code114.flatten(node);
        PrintUtil.printTree(node);
    }
}
