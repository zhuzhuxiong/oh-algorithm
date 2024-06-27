package com.labula.tree.construct;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

/**
 * 构建最大二叉树【nums --> tree】
 * @author zz
 */
public class No1Code654 {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums,lo,index - 1);
        root.right = build(nums,index + 1, hi);
        return root;
    }

    public static void main(String[] args) {
//        输出：[6,3,5,null,2,0,null,null,1]
        int[] nums = {3,2,1,6,0,5};
        No1Code654 code654 = new No1Code654();
        PrintUtil.printTree(code654.constructMaximumBinaryTree(nums));
    }
}
