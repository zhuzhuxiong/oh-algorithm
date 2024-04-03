package com.labula.tree;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.Arrays;

/**
 * @author zz
 */
public class Code101No5 {

    public boolean isSymmetric(TreeNode root) {
       return traverse(root, root);
    }

    private boolean traverse(TreeNode left, TreeNode right) {
        if (left == null && right ==null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return traverse(left.left, right.right) && traverse(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root0 = TreeNode.listToTree(Arrays.asList(new Integer[]{1,2,2,3,4,4,3}));
        TreeNode root1 = TreeNode.listToTree(Arrays.asList(new Integer[]{1,2,3}));
        TreeNode root2 = TreeNode.listToTree(Arrays.asList(new Integer[]{1,2,2,null,3,null,3}));
        PrintUtil.printTree(root1);
        PrintUtil.printTree(root2);
        System.out.println(new Code101No5().isSymmetric(root0));
        System.out.println(new Code101No5().isSymmetric(root1));
        System.out.println(new Code101No5().isSymmetric(root2));

        System.out.println(new Code101No5().practice(root0));
        System.out.println(new Code101No5().practice(root1));
        System.out.println(new Code101No5().practice(root2));
    }

    public boolean practice(TreeNode root){
        return traverse1(root,root);
    }

    private boolean traverse1(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && traverse1(left.left, right.right) && traverse1(left.right, right.left);
    }
}
