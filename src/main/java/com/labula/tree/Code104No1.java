package com.labula.tree;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.Arrays;

/**
 * @author zz
 */
public class Code104No1 {

    //记录树最深深度
    int res = 0;
    //记录当前节点深度，前序、后序位置功能体现，前序位置++，后序位置--；
    int depth = 0;

    /**
     * 遍历思路
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    void traverse(TreeNode node) {
        if (node == null) {
            return;
        }

        depth++;
        if (node.left == null && node.right == null) {
            res = Math.max(res, depth);
        }
        traverse(node.left);

        traverse(node.right);
        depth--;
    }

    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        return 1 + Math.max(left,right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.listToTree(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        PrintUtil.printTree(treeNode);
        System.out.println(new Code104No1().maxDepth(treeNode));
        System.out.println(new Code104No1().maxDepth1(treeNode));
        System.out.println(new Code104No1().practice(treeNode));
        System.out.println(new Code104No1().practice1(treeNode));
    }

    public int practice(TreeNode node) {
        if (node == null) {
            return 0;
        }
        depth++;
        if (node.left == null && node.right == null) {
            res = Math.max(depth, res);
        }
        practice(node.left);
        practice(node.right);
        depth--;
        return res;
    }

    public int practice1(TreeNode node) {
        return 0;
    }

}
