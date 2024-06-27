package com.labula.tree;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.Arrays;

/**
 * @author zz
 */
public class No1Code104 {

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

    /**
     * 递归
     * @param root
     * @return
     */
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
        System.out.println(new No1Code104().maxDepth(treeNode));
        System.out.println(new No1Code104().maxDepth1(treeNode));
        System.out.println(new No1Code104().practice(treeNode));
        System.out.println(new No1Code104().practice1(treeNode));
    }

    /**
     * 递归
     * @param node
     * @return
     */
    public int practice(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLength = practice(node.left);
        int rightLength = practice(node.right);
        return Math.max(leftLength, rightLength) + 1;
    }

    private int resDepth = 0;
    private int curDepth = 0;

    public int practice1(TreeNode node) {
        traverse1(node);
        return resDepth;
    }

    private void traverse1(TreeNode node) {
        if (node == null) {
            return;
        }

        curDepth++;
        if (node.left == null && node.right == null) {
            resDepth = Math.max(curDepth, resDepth);
        }

        traverse1(node.left);
        traverse1(node.right);
        curDepth--;
    }


}
