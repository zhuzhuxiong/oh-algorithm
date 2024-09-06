package com.labula.tree.construct;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 构建-根据前 中序
 * @author zz
 */
public class No2Code105 {

    Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd
            , int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];

        Integer index = inMap.get(rootVal);

        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);

        root.left = build(preorder, preStart + 1, preStart + leftSize
                , inorder, inStart, index);
        root.right = build(preorder, preStart + leftSize + 1, preEnd
                , inorder, index + 1, inEnd);
        return root;
    }


    public static void main(String[] args) {
        //3,9,20,null,null,15,7
        int[] pre = {3, 9, 20, 15, 7};
        int[] in = {9, 3, 15, 20, 7};
        TreeNode node = new No2Code105().buildTree(pre, in);
        PrintUtil.printTree(node);

        TreeNode node1 = new No2Code105().practice(pre, in);
        PrintUtil.printTree(node1);
    }


    Map<Integer, Integer> in = new HashMap();
    public TreeNode practice(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            in.put(inorder[i], i);
        }
        return build1(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private TreeNode build1(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        Integer index = in.get(rootVal);

        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = build1(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build1(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }



}
