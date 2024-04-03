package com.labula.tree.level;

import com.structure.tree.TreeNode;
import com.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zz
 */
public class Code199No2 {

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode treeNode = queue.get(size - 1);
            res.add(treeNode.val);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //[1,3,4]
        TreeNode root = TreeNode.listToTree(Arrays.asList(1,2,3,null,5,null,4));
        PrintUtil.printTree(root);
        System.out.println(new Code199No2().rightSideView(root));
    }
}
