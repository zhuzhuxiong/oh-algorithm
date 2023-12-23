package com.algo.divide;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 【分治】根据给出的前序遍历preorder 中序遍历 inorder 构建树，返回二叉树根节点
 *
 * @author zz
 */
public class BuildTree {

    public static TreeNode build(int[] preorder, int[] inorder) {
        /**中序数组 hash形式，key:节点值，value：索引*/
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        /** i:preorder中根节点索引，l:树的左边界，r:树的右边界 */
        return dfs(preorder, map, 0, 0, inorder.length - 1);
    }

    private static TreeNode dfs(int[] preorder, Map<Integer, Integer> inMap, int i, int l, int r) {
        if (r < l) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        /** 查询根节点在 inorder的位置 左边：左子树*/
        Integer m = inMap.get(preorder[i]);
        /** 递归 preorder中左子树，左子树的根节点 i+1 */
        root.left = dfs(preorder, inMap, i + 1, l, m - 1);
        /** [m-l]:左子树长度，根节点到最左边界； */
        root.right = dfs(preorder, inMap, i + 1 + m - l, m + 1, r);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3, 9, 2, 1, 7};
        int[] in = {9, 3, 1, 2, 7};
        TreeNode root = build(pre, in);
        PrintUtil.printTree(root);
    }
}
