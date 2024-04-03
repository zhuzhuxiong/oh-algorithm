package com.labula.tree;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.Arrays;

/**
 * 相同的树
 * @author zz
 */
public class Code100No3 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        //要判断不等于，等于就结束了，不等于才会继续
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeNode.listToTree(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        PrintUtil.printTree(treeNode1);
        TreeNode treeNode2 = TreeNode.listToTree(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}));
        PrintUtil.printTree(treeNode2);
        System.out.println(new Code100No3().practice(treeNode1, treeNode2));
    }


    public boolean practice(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return practice(p.left, q.left) && practice(p.right, q.right);
    }
}
