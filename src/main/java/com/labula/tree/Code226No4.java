package com.labula.tree;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.Arrays;

/**
 * 翻转二叉树
 * @author zz
 */
public class Code226No4 {

    /**
     * method1 迭代
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        traverse(root.left);
        traverse(root.right);
    }

    /**
     * method2 分解
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree1(root.left);
        TreeNode right = invertTree1(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.listToTree(Arrays.asList(new Integer[]{4,2,7,1,3,6,9}));
        PrintUtil.printTree(treeNode);
        TreeNode node = new Code226No4().invertTree(treeNode);
        PrintUtil.printTree(node);
    }

    public TreeNode practice(TreeNode root) {
        traverseP(root);
        return root;
    }

    private void traverseP(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        traverseP(root.left);
        traverseP(root.right);

    }
}
