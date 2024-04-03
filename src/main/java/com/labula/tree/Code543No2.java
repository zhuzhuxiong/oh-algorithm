package com.labula.tree;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.Arrays;

/**
 * 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和。
 * @author zz
 */
public class Code543No2 {

    int maxDiameter = 0;

    /**
     * method 1
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        int myDiameter = left + right;
        maxDiameter = Math.max(myDiameter, maxDiameter);

        traverse(node.left);
        traverse(node.right);
    }

    private int maxDepth(TreeNode node){
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        return Math.max(left, right) + 1;
    }


    /**
     * method 2
     * @param root
     * @return
     */
    public int diameterOfBinaryTree1(TreeNode root) {
        maxDepth1(root);
        return maxDiameter;
    }

    private int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth1(root.left);
        int right = maxDepth1(root.right);
        int myDiameter = left + right;
        maxDiameter = Math.max(myDiameter, maxDiameter);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.listToTree(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        PrintUtil.printTree(treeNode);
        System.out.println(new Code543No2().diameterOfBinaryTree(treeNode));
        System.out.println(new Code543No2().practice(treeNode));
        System.out.println(new Code543No2().practice1(treeNode));
    }

    /**
     * P 1
     * @param root
     * @return
     */
    public int practice(TreeNode root) {
        traversePrac(root);
        return maxDiameter;
    }

    private void traversePrac(TreeNode node) {
        if (node == null) {
            return;
        }
        int left = maxDepthPra(node.left);
        int right = maxDepthPra(node.right);
        int my = left + right;
        maxDiameter = Math.max(maxDiameter, my);

        traversePrac(node.left);
        traversePrac(node.right);

    }

    private int maxDepthPra(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepthPra(node.left);
        int right = maxDepthPra(node.right);
        return Math.max(left, right) + 1;
    }

    public int practice1(TreeNode root) {
        maxDiameter1(root);
        return maxDiameter;
    }

    private int maxDiameter1(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = maxDiameter1(node.left);
        int right = maxDiameter1(node.right);
        int my = left + right;
        maxDiameter = Math.max(my, maxDiameter);

        return 1 + Math.max(left, right);
    }
}
