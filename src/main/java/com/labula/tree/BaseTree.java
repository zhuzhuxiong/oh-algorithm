package com.labula.tree;

import com.structure.tree.TreeNode;

/**
 * 二叉树题目的递归解法可以分两类思路，
 * 第一类是遍历一遍二叉树得出答案，回溯算法核心框架
 * 第二类是通过分解问题计算出答案，动态规划核心框架。
 * @author
 */
public class BaseTree {

    public static void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        //前序位置--刚刚进入一个二叉树节点的时候执行
        traverse(node.left);
        //中序--一个二叉树节点左子树都遍历完，即将开始遍历右子树的时候执行
        traverse(node.right);
        //后序--将要离开一个二叉树节点的时候执行
    }
}
