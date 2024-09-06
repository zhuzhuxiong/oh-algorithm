package com.labula.tree.construct;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 【构建】- 后前序构建
 * @author zz
 */
public class No4Code889 {

    Map<Integer, Integer> postMap = new HashMap<>();
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        for (int i = 0; i < postorder.length; i++) {
            postMap.put(postorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                postorder, 0, postorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd,
                           int[] postorder, int postStart, int postEnd) {
        if (preStart > preEnd) {
            return null;
        }

        if (preStart == preEnd) {
            return new TreeNode(preorder[preStart]);
        }

        int rootVal = preorder[preStart];
        /** 前后序无法唯一确定左右分支边界，假定 preStart + 1 为左边界*/
        int left = preorder[preStart + 1];
        Integer index = postMap.get(left);

        int leftSize = index - postStart + 1;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                postorder, postStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                postorder, index + 1, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
//        输出：[1,2,3,4,5,6,7]
        int[] preorder = {1,2,4,5,3,6,7}, postorder = {4,5,2,6,7,3,1};
        No4Code889 code889 = new No4Code889();
        PrintUtil.printTree(code889.constructFromPrePost(preorder, postorder));
    }
}
